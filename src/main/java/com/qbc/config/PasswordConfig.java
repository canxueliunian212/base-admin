package com.qbc.config;

import com.qbc.util.MD5Util;
import org.eclipse.jetty.util.security.Password;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * @ClassNme PasswordConfig
 * @Description TODO
 * @Author chenpei
 * @Date 2024/10/22 13:55
 * @Version 1.0
 **/
@Component
public class PasswordConfig  implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Util.getMd5(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.contentEquals(this.encode(rawPassword));
    }
}
