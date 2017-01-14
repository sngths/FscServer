package com.tianxing.database.exception;

/**
 * Created by tianxing on 17/1/13.
 */
public class UserAlreadyExistException extends Exception{

    public UserAlreadyExistException(){
        super("用户已存在");
    }
}
