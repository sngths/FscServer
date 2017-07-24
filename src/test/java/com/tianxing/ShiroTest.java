package com.tianxing;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Assert;
import org.apache.shiro.util.Factory;

import java.util.UUID;

/**
 * Created by tianxing on 16/10/5.
 *
 */
public class ShiroTest {


    //@UIDTest
    public void helloWord(){
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager manager = factory.getInstance();
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("key", "value");
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        token.setRememberMe(true);
        System.out.println(session.getId().toString());
        System.out.println(UUID.randomUUID().toString());
        try{
            subject.login(token);
            subject.hasRole("");
            subject.checkPermission("");
            AuthenticationException authenticationException;
            AuthorizationException authorizationException;
            Session session1;

        }catch (UnauthenticatedException e){
            //登录失败
        }
        Assert.isTrue(subject.isAuthenticated());
        subject.logout();
    }

}
