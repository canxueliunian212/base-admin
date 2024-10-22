package com.qbc.config;

import org.eclipse.jetty.util.security.Password;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @ClassNme PasswordConfig
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/22 13:55
 * @Version 1.0
 **/
public class PasswordConfig  implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {

        return "";
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return false;
    }
}
