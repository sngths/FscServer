package com.tianxing.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * Created by tianxing on 2017/5/25.
 * springSecurity配置
 */
@Configuration
@EnableWebSecurity
//@EnableOAuth2Sso
//@EnableGlobalMethodSecurity(securedEnabled = true)
//@Order(-1)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    //配置如何通过拦截器保护请求
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .anyRequest().authenticated();
        /*http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()
                //.anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .addLogoutHandler((request, response, authentication) -> {

                })
                .permitAll()
        .and().csrf().disable();*/

    }

    //配置user-detail服务
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //添加内存认证用户数据
        //auth.inMemoryAuthentication()
                //.withUser("user1").password("password").roles("USER").and()
                //.withUser("user2").password("password").roles("USER");

        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);

    }

    @Override
    @Bean
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    //配置SpringSecurity的filter链

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
        //web.ignoring()

    }




    /**
     * 自定义账户认证信息
     * */
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDetailsServiceImpl();
    }

    /**
     * 密码加密方式
     * */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
