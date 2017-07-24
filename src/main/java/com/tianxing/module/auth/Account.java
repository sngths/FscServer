package com.tianxing.module.auth;

import com.tianxing.module.auth.token.AuthenticationToken;

/**
 * Created by tianxing on 2017/5/13.
 * 单个用户的账号信息 包含用户账号权限检测 和 角色认定
 */
public interface Account {







   /**
    * 匿名登录
    * */
    Account login() throws Exception;

    /**
     * 登陆 验证用户信息 失败则抛出异常 登陆成功后完成 session创建等操作
     * */
    void login(AuthenticationToken token) throws Exception;


    /**
     * 登出 删除 session 认证信息 等用户会话数据
     * */
    void logout();



    boolean isAuthenticated();

    /**
     * 验证用户类型
     * */
    void hasRole(String... role) throws Exception;


    /**
     * 验证账户权限
     * */
    void checkPermissions(String... permission) throws Exception;


}
