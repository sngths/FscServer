package com.tianxing.mybatis;

import com.tianxing.config.DataBaseConfig;
import com.tianxing.database.dao.result.UserInfo;
import com.tianxing.database.AssignmentMapper;
import com.tianxing.database.mapper.UserMapper;
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
            UserInfo userInfo = mapper.getUserInfoByName("user1");
            logger.debug(userInfo.getUsername());
            logger.debug(userInfo.getPassword());
            logger.debug(userInfo.getEmail());

        }finally {
            session.close();
        }

    }



    @Test
    public void insert(){
        try (SqlSession session = factory.openSession()){
            UserMapper mapper = session.getMapper(UserMapper.class);
            logger.debug(String.valueOf(mapper.createStudent("user3", "123456")));
        }
    }

    /**
     * 批量插入老师和学生账号
     * */
    @Test
    public void accountInit(){
        try (SqlSession session= factory.openSession()) {
            UserMapper mapper =session.getMapper(UserMapper.class);
            //六个年级 每个年级三个班级
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j <3 ; j++) {

                }
            }
        }



    }


    @Test
    public void assignment(){
        SqlSession session = factory.openSession();
        try {
            AssignmentMapper mapper = session.getMapper(AssignmentMapper.class);
            mapper.insert("user3");

        }finally {
            session.close();
        }
    }
}
