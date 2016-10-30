package com.tianxing.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tianxing on 16/10/19.
 */
public class LogggerTest {

    //@Test
    public void slf4j(){
        Logger logger = LoggerFactory.getLogger(LogggerTest.class);
        logger.info("slf4j test");
    }
}
