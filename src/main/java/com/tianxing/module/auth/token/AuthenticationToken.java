package com.tianxing.module.auth.token;

/**
 * Created by tianxing on 2017/5/9.
 *
 */
public interface AuthenticationToken {


    Object getPrincipal();


    Object getCredentials();
}
