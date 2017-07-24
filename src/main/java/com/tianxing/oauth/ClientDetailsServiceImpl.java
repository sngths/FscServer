package com.tianxing.oauth;

import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;

/**
 * Created by tianxing on 2017/6/15.
 * OAuth 2.0 客户端认证信息查询服务
 *
 */
public class ClientDetailsServiceImpl implements ClientDetailsService {


    @Override
    public ClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        return null;
    }
}
