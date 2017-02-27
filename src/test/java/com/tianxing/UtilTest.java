package com.tianxing;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Server;

import java.util.Date;

/**
 * Created by tianxing on 16/10/27.
 */
public class UtilTest {

    Logger logger = LoggerFactory.getLogger(UtilTest.class);

    @Test
    public void dateTest(){
        logger.info(Server.getDate());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Server.getDate());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Server.getDate());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info(Server.getDate());
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void test(){
        Date date = new Date();
        try {
            Class a = Class.forName("java.util.Date");
            System.out.print(a.getModifiers());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
