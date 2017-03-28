package com.tianxing.service;

import org.h2.util.AbbaLockingDetector;
import org.junit.Test;

/**
 * Created by tianxing on 2017/3/28.
 */
public class ServiceMediatorTest {

    @Test
    public void mediator(){
        ServiceMediator mediator = new ServiceMediatorImpl();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {

            }
        };
    }
}
