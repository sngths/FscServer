package com.tianxing.module.auth.exception;

/**
 * Created by tianxing on 2017/5/13.
 * 认证失败 抛出该异常
 */
public class AuthenticationException extends Exception{

    public AuthenticationException(){
        super();
    }

    public AuthenticationException(String msg){
        super(msg);
    }
}
