package com.qbc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @ClassNme SecurityConfig
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/26 12:13
 * @Version 1.0
 **/
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private PasswordConfig passwordConfig;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {

    }
}
