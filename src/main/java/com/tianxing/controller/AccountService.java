package com.tianxing.controller;

import com.tianxing.pojo.http.ResponseWrapper;
import com.tianxing.pojo.http.response.LoginResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tianxing on 2017/4/11.
 * 账户相关 认证(authenticate)  授权(authorize)
 */
@RestController
public class AccountService {



    /**
     * 用户认证
     * */
    @RequestMapping(value ="v1/login/result", method = RequestMethod.GET, consumes = "application/json")
    public ResponseWrapper authenticate(){
        //检查IP

        LoginResult result = null;
        return new ResponseWrapper(result, LoginResult.class);
    }


    /**
     * 用户授权 通过上传RefreshToken来获取新的token
     * */
    @RequestMapping(value = "v1/login/token", method = RequestMethod.GET, consumes = "application/json")
    public ResponseWrapper authorize(@RequestHeader(value = "refresh_token") String token){

        return new ResponseWrapper("", String.class);
    }

    /**
     * 获取老师账户信息
     * */
    @RequestMapping(value = "v1/account/teacher", method = RequestMethod.GET, consumes = "application/json")
    public ResponseWrapper teacherAccount(@RequestHeader(value = "refresh_token") String token){
        return null;
    }

    /**
     * 获取学生账户信息
     * */
    @RequestMapping(value = "v1/account/student", method = RequestMethod.GET, consumes = "application/json")
    public ResponseWrapper studentAccount(@RequestHeader(value = "token") String token){
        return null;
    }

}
