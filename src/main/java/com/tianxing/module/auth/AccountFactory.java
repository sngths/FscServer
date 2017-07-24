package com.tianxing.module.auth;

import com.tianxing.module.auth.account.AccountContext;

/**
 * Created by tianxing on 2017/5/23.
 *
 */
public interface AccountFactory {


    Account createAccount(AccountContext context);
}
