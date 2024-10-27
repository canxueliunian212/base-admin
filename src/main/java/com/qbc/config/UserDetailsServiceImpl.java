package com.qbc.config;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @ClassNme UserDetailsServiceImpl
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/26 20:30
 * @Version 1.0
 **/
public class UserDetailsServiceImpl implements UserDetailsService {



    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
