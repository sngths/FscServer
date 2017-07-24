package com.tianxing.controller;

import com.tianxing.codes.exception.DecodeException;
import com.tianxing.exception.UnauthorizedException;
import com.tianxing.pojo.http.RequestWrapper;
import com.tianxing.pojo.http.ResponseWrapper;
import com.tianxing.pojo.http.request.UsernameAndPassword;
import com.tianxing.pojo.http.response.LoginResponse;
import com.tianxing.pojo.info.TeacherInfo;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by tianxing on 2017/4/11.
 * 账户相关 认证(authenticate)  授权(authorize)
 */
@RestController
public class AccountController extends BaseController{


    /**
     * 用户认证
     * */
    @RequestMapping(value ="login/result", method = RequestMethod.POST)
    public ResponseWrapper authenticate(@RequestBody RequestWrapper requestWrapper, HttpServletRequest request) throws DecodeException {
        //检查IP

        //UsernameAndPassword usernameAndPassword = requestWrapper.deserialize(UsernameAndPassword.class);

        TeacherInfo info = new TeacherInfo();
        info.setId("123");
        info.setUserName("teacher1");
        info.setNickName("老师1");
        info.setUserIconUrl("...");

        info.setCourseID("123");
        info.setCourseName("数学");
        info.setClassID("1", "2", "3");

        LoginResponse result = new LoginResponse();
        result.setUserType(1);
        result.setToken("token");
        result.setRefreshToken("refreshToken");
        result.setTeacherInfo(info);
        System.out.println(LoginResponse.class.getName()+ "  "+ LoginResponse.class.getName().hashCode());

        ResponseWrapper responseWrapper = new ResponseWrapper(result);
        responseWrapper.setStatusCode(200);


        return responseWrapper;
    }


    /**
     * 用户授权 通过上传RefreshToken来获取新的token
     * */
    @RequestMapping(value = "login/token", method = RequestMethod.GET)
    public void authorize(@RequestHeader("refresh_token") String refresh_token , HttpServletResponse response)throws UnauthorizedException{

        response.addHeader("token", "server_token_value");
        System.out.println("授权" + refresh_token);
    }

    /**
     * 获取老师账户信息
     * */
    @RequestMapping(value = "account/teacher", method = RequestMethod.GET)
    public ResponseWrapper teacherAccount(@RequestHeader(value = "token") String token) throws Exception{
        System.out.println(token);
        if (token == null || token.equals("")){
            throw new UnauthorizedException();
        }
        return new ResponseWrapper("", String.class);
    }

    /**
     * 获取学生账户信息
     * */
    @GetMapping(value = "account/student")
    public ResponseWrapper studentAccount(@RequestHeader(value = "token") String token)throws UnauthorizedException{
        return null;
    }

}
