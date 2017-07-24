package com.tianxing.module.auth;


import com.tianxing.components.AccountManager;
import com.tianxing.components.mediator.ComponentMediator;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by tianxing on 2017/3/28.
 *
 */

public class AccountManagerImpl implements AccountManager {


    private ComponentMediator mediator;


    private AtomicBoolean isRegistrable = new AtomicBoolean(true);//是否开放注册


    //已登录用户


    //未登录用户和匿名用户



    @Override
    public String getName() {
        return ServiceName;
    }

    @Override
    public void initialize(ComponentMediator mediator) {
        this.mediator = mediator;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void destroy() {

    }




    @Override
    public Account createAccount() {
        return null;
    }

    @Override
    public Account getAccount(String token) {
        return null;
    }



    @Override
    public void authorization(String token) throws Exception {

    }




}
