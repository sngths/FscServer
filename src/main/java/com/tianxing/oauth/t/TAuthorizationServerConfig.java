package com.tianxing.oauth.t;

import com.tianxing.security.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.bind.RelaxedPropertyResolver;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * Created by tianxing on 2017/6/23.
 *
 */


//@Configuration
//@EnableAuthorizationServer
public class TAuthorizationServerConfig extends AuthorizationServerConfigurerAdapter  implements EnvironmentAware {


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;




    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.tokenStore(tokenStore())
                .userDetailsService(new UserDetailsServiceImpl())
                .authenticationManager(authenticationManager);
    }


    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret("secret")
                .scopes("read", "write")
                .authorities("ROLE_ADMIN", "ROLE_USER")//认证客户端的用户类型
                .authorizedGrantTypes("password", "refresh_token")
                .accessTokenValiditySeconds(3600);
    }

    @Bean
    public TokenStore tokenStore(){
        return new InMemoryTokenStore();
    }

    @Override
    public void setEnvironment(Environment environment) {
        //取得当前运行环境中的参数配置
        RelaxedPropertyResolver resolver = new RelaxedPropertyResolver(environment);
    }


    /**
     * 自定义账户认证信息
     * */
    /*@Bean
    public UserDetailsService userDetailsService(){
        return new FscUserDetailsService();
    }*/
}
