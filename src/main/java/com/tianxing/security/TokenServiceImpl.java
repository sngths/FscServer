package com.tianxing.security;

import org.springframework.security.core.token.Token;
import org.springframework.security.core.token.TokenService;

/**
 * Created by tianxing on 2017/6/7.
 *
 */
public class TokenServiceImpl implements TokenService{


    @Override
    public Token allocateToken(String extendedInformation) {
        return null;
    }

    @Override
    public Token verifyToken(String key) {
        return null;
    }
}
