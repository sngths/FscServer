package com.tianxing.webapi.controller;

import com.tianxing.codes.exception.DecodeException;
import com.tianxing.exception.UnauthorizedException;
import com.tianxing.pojo.http.ResponseWrapper;
import com.tianxing.webapi.controller.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by tianxing on 2017/4/15.
 * 处理集中异常
 */
@ControllerAdvice//异常统一处理
@RequestMapping(path= "v1/")//API版本  返回数据类型  //consumes = "application/json"
public class BaseController implements Controller {



    /**
     * 未授权异常处理
     * */
    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public ResponseWrapper unauthorized(){
        return new ResponseWrapper("没有权限", String.class);
    }

    /**
     * 请求方法不支持
     * */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseWrapper methodNotSupported(){
        return new ResponseWrapper("请求不支持", String.class);
    }

    /**
     * 请求错误 无法解析上传的数据
     * */
    @ExceptionHandler(DecodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseWrapper decodeError(){
        return new ResponseWrapper("请求错误", String.class);
    }


    /**
     * 检查权限  token组成:base64(username+":"+expirationTime+":"+md5Hex(username+":"+expirationTime+":"+password+":"+key))
     * */
    protected void check(String token) throws Exception{

    }


}
