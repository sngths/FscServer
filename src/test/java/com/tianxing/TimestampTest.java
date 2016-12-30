package com.tianxing;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by tianxing on 16/12/29.
 */
public class TimestampTest {
    Logger logger = LoggerFactory.getLogger(TimestampTest.class);

    @Test
    public void test(){
        long time = System.currentTimeMillis();

        Timestamp timestamp= new Timestamp(time);
        LocalDateTime dateTime = timestamp.toLocalDateTime();
        logger.debug(timestamp.toString());
        logger.debug(String.valueOf(dateTime.getYear()));
        logger.debug(String.valueOf(dateTime.getMonth().getValue()));
        logger.debug(String.valueOf(dateTime.getDayOfMonth()));
        logger.debug(String.valueOf(dateTime.getHour()));
        logger.debug(String.valueOf(dateTime.getMinute()));
        logger.debug(String.valueOf(dateTime.getSecond()));

    }
}
