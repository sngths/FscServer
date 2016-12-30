package com.tianxing.mybatis;

import com.tianxing.config.DataBaseConfig;
import mybatis.mapper.UserCreateMapper;
import mybatis.pojo.User;
import mybatis.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



/**
 * Created by tianxing on 16/10/18.
 *
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DataBaseConfig.class)
public class MyBatisTest {
    Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
    @Autowired
    SqlSessionFactory factory;


    @Test
    public void select(){
        SqlSession session = factory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            User user = mapper.getUser("user1").get(0);
            logger.debug(user.getUsername());
            logger.debug(user.getPassword());
            logger.debug(user.getEmail());

        }finally {
            session.close();
        }

    }



    @Test
    public void insert(){
        try (SqlSession session = factory.openSession()){
            UserCreateMapper mapper = session.getMapper(UserCreateMapper.class);
            logger.debug(String.valueOf(mapper.create("user3", "123456", "")));
        }
    }
}
