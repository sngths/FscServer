package com.tianxing;

import com.tianxing.config.DataBaseConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
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

    @Autowired
    SqlSessionFactory factory;


    @Test
    public void test1(){
        SqlSession session = factory.openSession();
        try {

        }finally {
            session.close();
        }

    }
}
