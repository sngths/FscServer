package com.tianxing.config;


import com.tianxing.database.AssignmentMapper;
import com.tianxing.database.mapper.UserMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
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
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.test.context.ActiveProfiles;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by tianxing on 16/10/11.
 *
 */
@Configuration
@ActiveProfiles("dev")
public class DataBaseConfig {


    @Bean
    @Profile("prod")
    public DataSource mysqlDataSource(){
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
    public DataSource embeddedDataSource(){
        return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2)
                .addScript("classpath:schema_h2.sql")
                .addScript("classpath:test_data.sql")
                .build();
    }




    @Bean
    @Autowired
    public SqlSessionFactory createFactory(DataSource dataSource){

        //创建数据库事务方式
        TransactionFactory transactionFactory = new JdbcTransactionFactory();
        //创建数据库运行环境
        Environment environment = new Environment("dev", transactionFactory, dataSource);
        //构建配置对象
        org.apache.ibatis.session.Configuration configuration = new org.apache.ibatis.session.Configuration(environment);

        configuration.addMapper(UserMapper.class);
        configuration.addMapper(AssignmentMapper.class);
        //configuration.addMappers("com.tianxing.database.mapper");
        //配置属性元素 在上下文中使用
        Properties properties;
        if (configuration.getVariables() == null){
             properties = new Properties();
        }else {
            properties = configuration.getVariables();
        }
        properties.setProperty("username", "fsc");
        properties.setProperty("password", "123456");
        configuration.setVariables(properties);
        //设置
        configuration.setCacheEnabled(true);

        //配置类型别名
        TypeAliasRegistry aliasRegistry = configuration.getTypeAliasRegistry();
        //aliasRegistry.registerAlias("userInfo", UserInfo.class);
        aliasRegistry.registerAliases("com.tianxing.database.dao.param");//扫描包加载别名
        aliasRegistry.registerAliases("com.tianxing.database.dao.result");

        //类型处理器
        TypeHandlerRegistry handlerRegistry = configuration.getTypeHandlerRegistry();


        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(configuration);
        return factory;
    }



    /**
     * 根据SQL文件建表
     * */
    @Autowired
    private void createTables(SqlSessionFactory factory){
            SqlSession session = factory.openSession();
        try {
            ScriptRunner runner = new ScriptRunner(session.getConnection());
            runner.setAutoCommit(true);
            runner.setStopOnError(true);
            //runner.runScript(getResourceAsReader("schema_mysql.sql"));
            runner.closeConnection();
        }finally {
            session.close();
        }

    }


}
