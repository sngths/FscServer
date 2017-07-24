package com.tianxing.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by tianxing on 2017/6/5.
 * 自定义用户认证信息
 *
 */
public class FscUserDetails implements UserDetails {

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //用户权限集合
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add((GrantedAuthority) () -> "ROLE_USER");
        return authorities;
    }

    @Override
    public String getPassword() {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode("password");
    }

    @Override
    public String getUsername() {
        return "username";
    }

    @Override
    public boolean isAccountNonExpired() {
        //查询用户账号是否过期
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        //查询用户账号是否锁定
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        //查询证书是否过期
        return true;
    }

    @Override
    public boolean isEnabled() {
        //查询用户是否可用
        return true;
    }
}
