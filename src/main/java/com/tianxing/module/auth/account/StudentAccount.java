package com.tianxing.module.auth.account;

import com.tianxing.module.auth.Account;
import com.tianxing.module.auth.token.AuthenticationToken;

/**
 * Created by tianxing on 2017/5/13.
 */
public class StudentAccount implements Account {
    @Override
    public Account login() throws Exception {
        return null;
    }

    @Override
    public void login(AuthenticationToken token) throws Exception {

    }

    @Override
    public void logout() {

    }

    @Override
    public boolean isAuthenticated() {
        return false;
    }

    @Override
    public void hasRole(String... role) throws Exception {

    }

    @Override
    public void checkPermissions(String... permission) throws Exception {

    }
}
