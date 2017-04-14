package com.tianxing.controller;

import com.tianxing.data.account.AccountManager;
import com.tianxing.data.session.SessionManager;
import com.tianxing.pojo.transfer.response.LoginInfoResponse;
import com.tianxing.pojo.transfer.response.StudentInfoResponse;
import com.tianxing.pojo.transfer.response.TeacherInfoResponse;
import com.tianxing.pojo.transfer.response.TeacherLoginInfo;
import com.tianxing.pojo.transfer.received.UsernameAndPassword;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import util.Server;


/**
 * Created by tianxing on 16/9/7.
 *
 */
@RestController
public class LoginController {

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private AccountManager accountManager;
    @Autowired
    private SessionManager sessionManager;

    /**
     * 客户端登陆  验证用户名密码 创建session
     * */
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public TeacherLoginInfo login(@RequestBody UsernameAndPassword usernameAndPassword){
        System.out.println(usernameAndPassword.getUsername() + "  " + usernameAndPassword.getPassword());

//        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
//        SecurityManager manager = factory.getInstance();
//        SecurityUtils.setSecurityManager(manager);
//        Subject currentUser = SecurityUtils.getSubject();
//        Session session = currentUser.getSession();
//        if (!currentUser.isAuthenticated()){
//            UsernamePasswordToken token = new UsernamePasswordToken(usernameAndPassword.getUsername(), usernameAndPassword.getPassword());
//            token.setRememberMe(true);
//            currentUser.login(token);
//        }



        return new TeacherLoginInfo();
    }



    /**
     * 用户登录
     * */
    @RequestMapping(value = "/mlogin", method = RequestMethod.POST, consumes = "application/json")
    public LoginInfoResponse userLogin(@RequestBody UsernameAndPassword usernameAndPassword){
        logger.info("收到登录请求   用户名:" + usernameAndPassword.getUsername() + "   密码:" + usernameAndPassword.getPassword());
        //验证用户名密码
        if (accountManager.verify(usernameAndPassword.getUsername(), usernameAndPassword.getPassword())){
            //登录成功
            LoginInfoResponse info = new LoginInfoResponse();
            com.tianxing.data.session.Session session = sessionManager.createSession(usernameAndPassword.getUsername());
            info.setToken(session.getId());
            info.setDate(Server.getDate());
            //判断用户类型
            if (accountManager.getUserType(usernameAndPassword.getUsername()) == AccountManager.UserType.Student){
                info.setUserType("student");
            }else if (accountManager.getUserType(usernameAndPassword.getUsername()) == AccountManager.UserType.Teacher){
                info.setUserType("teacher");
            }else {
                info.setUserType("unknown");
            }
            return info;
        }else {
            return null;
        }

    }





    /**
     * 登录测试
     * */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public TeacherLoginInfo loginTest(){
        TeacherLoginInfo teacherLoginInfo = new TeacherLoginInfo();

        //Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        //SecurityManager manager = factory.getInstance();
        //SecurityUtils.setSecurityManager(manager);
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession();
        teacherLoginInfo.setToken(session.getId().toString());
        if (!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken("lenic", "123456");
            //token.setRememberMe(true);
            currentUser.login(token);
        }
        return teacherLoginInfo;
    }


    /**
     * 取得学生的用户信息
     * */
    @RequestMapping(value = "/student/info", method = RequestMethod.GET, consumes = "application/json")
    public StudentInfoResponse getStudentInfo(@RequestHeader(value = "token") String token){
        com.tianxing.data.session.Session session = sessionManager.getSession(token);
        String username = session.getUserName();
        return accountManager.getStudentInfoResponse(username);
    }


    /**
     * 取得老师的用户信息
     * */
    @RequestMapping(value = "/teacher/info", method = RequestMethod.GET, consumes = "application/json")
    public TeacherInfoResponse getTeacherInfo(@RequestHeader(value = "token") String token){
        com.tianxing.data.session.Session session = sessionManager.getSession(token);
        String username = session.getUserName();
        return accountManager.getTeacherInfoResponse(username);
    }
}
