package com.tianxing.redisTest;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.Server;

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
}