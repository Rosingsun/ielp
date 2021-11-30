package com.mudongheng.ielp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author 幕冬
 * @since 2021年10月26日
 */
public class PasswordEncoderUtil {

    private final static PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encode(String password) {
        return encoder.encode(password);
    }

    public static boolean matches(String rawPassword, String encoderPassword) {
        return encoder.matches(rawPassword, encoderPassword);
    }
}
