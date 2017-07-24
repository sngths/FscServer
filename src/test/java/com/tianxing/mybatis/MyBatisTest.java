package com.tianxing.mybatis;

import com.tianxing.config.DataBaseConfig;
import com.tianxing.database.dao.result.UserInfo;
import com.tianxing.database.mapper.AssignmentMapper;
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
 */

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = DataBaseConfig.class)
public class MyBatisTest {
    Logger logger = LoggerFactory.getLogger(MyBatisTest.class);
    //@Autowired
    SqlSessionFactory factory;


    //@Test
    public void select() {
        SqlSession session = factory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            UserInfo userInfo = mapper.getUserInfoByName("user1");
            logger.debug(userInfo.getUsername());
            logger.debug(userInfo.getPassword());
            logger.debug(userInfo.getEmail());
            session.commit();
        } catch (Exception e){
            session.rollback();
        }finally {
            session.close();
        }
    }


    /**
     * 创建一个用户
     * */
    //@Test
    public void insertUser() {
        SqlSession session = factory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            Integer id  = -1;
            logger.debug(String.valueOf(mapper.createUser(id, "user3", "123456", "s")));
            logger.debug(String.valueOf(id));
            session.commit();
        }catch (Exception e){
            e.printStackTrace();
            session.rollback();
        }finally {
            session.close();
        }
    }

    /**
     * 创建一个班级
     * */
    //@Test
    public void createClass(){
        SqlSession session = factory.openSession();
        try {
            UserMapper mapper = session.getMapper(UserMapper.class);
            int a = mapper.createClass(1,3,"一年级三班", null);
            logger.error(String.valueOf(a));
            session.commit();
            logger.error(String.valueOf(a));
        } catch (Exception e){
            session.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
    }

    /**
     * 批量插入老师和学生账号
     */
    //@Test
    public void accountInit() {
        try (SqlSession session = factory.openSession()) {
            UserMapper mapper = session.getMapper(UserMapper.class);
            //六个年级 每个年级三个班级
            for (int i = 1; i < 7; i++) {
                for (int j = 1; j < 3; j++) {

                }
            }
        }


    }



}
