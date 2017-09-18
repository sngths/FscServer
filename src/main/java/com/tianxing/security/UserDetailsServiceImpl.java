package com.tianxing.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by tianxing on 2017/6/2.
 * 自定义用户认证机制
 *
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    //返回对象可在SecurityContextHolderSecurityContextHolder中取得
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //载入用户认证信息  先在缓存中查找 再去数据库查找
        //BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        System.out.println(username);

        if (username.equals("username")){
            return new UserDetailsImpl();
        }else {
            throw  new UsernameNotFoundException("未找到用户:" + username);
        }

    }
}
