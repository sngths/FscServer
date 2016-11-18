package com.tianxing.test;

import com.tianxing.data.account.AccountManager;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tianxing on 2016/10/30.
 */
public class AccountTest {

    Logger logger = LoggerFactory.getLogger(AccountTest.class);
    @Test
    public void accountmanager(){
        AccountManager manager = new AccountManager();
        logger.info("班级数:" + String.valueOf(manager.getClassInfoMap().size()));
        logger.info("学生数:" + String.valueOf(manager.getStudentInfoMap().size()));
        logger.info("老师数:" + String.valueOf(manager.getTeacherInfoMap().size()));
    }
}
