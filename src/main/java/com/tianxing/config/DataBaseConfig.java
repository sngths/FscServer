package com.tianxing.config;


import com.tianxing.database.dao.result.UserInfo;
import com.tianxing.database.mapper.AssignmentMapper;
import com.tianxing.database.mapper.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.apache.ibatis.type.TypeAliasRegistry;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import static org.apache.ibatis.io.Resources.getResourceAsReader;

/**
 * Created by tianxing on 16/10/11.
 *
 */
@Configuration
@ActiveProfiles("dev")
public class DataBaseConfig {


    //@Bean
    //@Profile("prod")
    public DataSource mysqlDataSource() {
        //创建数据库连接池
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://172.24.1.1:3306/fsc");
        dataSource.setUsername("fsc");
        dataSource.setPassword("123456");
        return dataSource;
    }

    @Bean
    //@Profile("dev")
    public DataSource embeddedDataSource() {
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema_h2.sql")
                .addScript("classpath:database/test_data.sql")
                .build();
    }


    public DataSource h2DataSource() {
        PooledDataSource dataSource = new PooledDataSource();
        dataSource.setDriver("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:h2db");
        dataSource.setUsername("sa");
        dataSource.setPassword("");
        return dataSource;
    }


    @Bean(name = "sqlSessionFactory")
    @Autowired
    public SqlSessionFactory createFactory(DataSource dataSource) {

        //创建数据库事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //创建数据库运行环境
        Environment environment = new Environment("dev", transactionFactory, dataSource);
        //构建配置对象
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);
        //配置类型别名 要在添加映射类之前 配置别名
        TypeAliasRegistry aliasRegistry = configuration.getTypeAliasRegistry();
        aliasRegistry.registerAliases("com.tianxing.database.dao.param");
        aliasRegistry.registerAliases("com.tianxing.database.dao.result");
        //添加映射文件
        configuration.addMappers("com.tianxing.database.mapper");
        //配置属性元素 在上下文中使用
        Properties properties = configuration.getVariables();
        properties.setProperty("username", "fsc");
        properties.setProperty("password", "123456");
        configuration.setVariables(properties);
        //设置
        configuration.setCacheEnabled(true);
        //类型处理器
        TypeHandlerRegistry handlerRegistry = configuration.getTypeHandlerRegistry();
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
        //建表

        return factory;
    }


    //@Bean
    public SqlSessionFactory createFactoryFromXml() throws IOException {
        InputStream stream = Resources.getResourceAsStream("mybatis-config-h2.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        runSqlScript(factory, "schema_h2.sql");
        return factory;
    }





    /**
     * mybatis执行sql脚本文件
     * */
    private void runSqlScript(SqlSessionFactory factory, String filePath) throws IOException {
        SqlSession session = factory.openSession();
        try {
            ScriptRunner runner = new ScriptRunner(session.getConnection());
            runner.setAutoCommit(true);
            runner.setStopOnError(true);
            runner.runScript(getResourceAsReader(filePath));
            runner.closeConnection();
        } finally {
            session.close();
        }
    }


}
