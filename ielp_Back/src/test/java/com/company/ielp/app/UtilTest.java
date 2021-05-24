package com.company.ielp.app;

import com.company.ielp.app.model.enums.VOState;
import com.company.ielp.app.utils.JwtUtil;
import org.junit.jupiter.api.Test;

public class UtilTest {
    @Test
    void test() {
        System.out.println(VOState.NOT_FOUND);
    }

    @Test
    void test2() {
        String token = JwtUtil.createToken(1);
        System.out.println(token);

        boolean b = JwtUtil.verifyToken(token, 1);

        System.out.println(b);

        Integer s = JwtUtil.getAudience(token);

        System.out.println(s);

    }
}
