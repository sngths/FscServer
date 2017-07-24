package com.tianxing.module.auth.exception;

/**
 * Created by tianxing on 2017/5/13.
 * 授权失败 抛出该异常
 */
public class AuthorizationException extends Exception {

    public AuthorizationException(){
        super();
    }

    public AuthorizationException(String msg){
        super(msg);
    }
}
