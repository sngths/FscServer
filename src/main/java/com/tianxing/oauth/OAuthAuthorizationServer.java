package com.tianxing.oauth;

import com.tianxing.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.*;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Created by tianxing on 2017/6/8.
 * OAuth 2.0 认证服务配置
 */


@Configuration
@EnableAuthorizationServer
public class OAuthAuthorizationServer extends AuthorizationServerConfigurerAdapter {


    @Autowired
    private AuthenticationManager authenticationManager;


    @Autowired
    private TokenStore tokenStore;

    @Autowired
    private UserDetailsService userDetailsService;


    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        //

        System.out.println("配置认证服务");
        if (userDetailsService != null){
            System.out.println(userDetailsService.getClass().getName());
        }

        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .userDetailsService(userDetailsService);

    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //
        //clients.withClientDetails();
        clients.inMemory()
                .withClient("client")
                .authorizedGrantTypes("refresh_token", "password", "client_credentials")
                .authorities("ROLE_ADMIN", "ROLE_USER")
                .scopes("read", "write")
                //.resourceIds("oauth-resource")
                .secret("secret")
                .accessTokenValiditySeconds(5000);

    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        super.configure(security);
        //检测用户是否已经认证
        //security.checkTokenAccess("isAuthenticated()");
    }

    //@Bean
    /*public DefaultTokenServices tokenService() {
        DefaultTokenServices tokenServices = new DefaultTokenServices();
        tokenServices.setSupportRefreshToken(true);
        tokenServices.setTokenStore(tokenStore);
        return tokenServices;
    }*/


    @Bean
    public TokenStore tokenStore() {
        return new InMemoryTokenStore();
    }


    /**
     * OAuth认证服务器配置
     * */
    /*@Bean
    public AuthorizationServerConfigurer authorizationServerConfigurer(){
        return new AuthorizationServerConfigurerImpl();
    }*/




}
