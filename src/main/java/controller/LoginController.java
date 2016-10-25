package controller;

import entity.info.TeacherLoginInfo;
import entity.request.UsernameAndPassword;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by tianxing on 16/9/7.
 *
 */
@RestController
@RequestMapping("/login")
public class LoginController {



    /**
     * 客户端登陆
     * */
    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
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




    @RequestMapping(method = RequestMethod.GET)
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
}
