package com.tianxing.module.auth.token;


/**
 * Created by tianxing on 2017/5/11.
 *
 */
public class UsernameAndPasswordToken implements AuthenticationToken {

    private String username;

    private String password;

    private boolean rememberMe = false;

    private String host;


    public UsernameAndPasswordToken(){

    }


    public UsernameAndPasswordToken(String username, String password){
        this.username = username;
        this.password = password;
    }


    @Override
    public Object getPrincipal() {
        return getUsername();
    }

    @Override
    public Object getCredentials() {
        return getPassword();
    }


    public String getUsername() {
        return getPassword();
    }

    public String getPassword() {
        return password;
    }

    public boolean isRememberMe() {
        return rememberMe;
    }

    public String getHost() {
        return host;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
