package com.mudongheng.ielp.api.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mudongheng.ielp.api.model.entity.User;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 幕冬
 * @since 2021年10月16日
 */
@Slf4j
public class JWTUtil {

    private final static String PRIVATE_KEY = "MuDongHeng!^GD@#^SCV!%#21358s";

    private final static Integer EXPIRES_TIME = 2;

    public static String sign(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("header", "666");

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.HOUR, EXPIRES_TIME);

        return JWT.create()
                .withHeader(map)
                .withClaim("userId", user.getId())
                .withClaim("username", user.getUsername())
                .withIssuedAt(new Date())
                .withExpiresAt(calendar.getTime())
                .sign(Algorithm.HMAC256(PRIVATE_KEY));
    }

    public static DecodedJWT verify(String token) {
        DecodedJWT verify;
        try {
            verify = JWT
                    .require(Algorithm.HMAC256(PRIVATE_KEY))
                    .build()
                    .verify(token);
        } catch (JWTVerificationException e) {
            log.error("验证异常，可能token被篡改");
            return null;
        } catch (IllegalArgumentException e) {
            log.error("非法参数传递");
            return null;
        }
        return verify;
    }

    public static Integer getUserId(String token) {
        DecodedJWT verify = verify(token);
        if (verify != null) {
            return verify.getClaim("userId").asInt();
        }
        return null;
    }

    public static String getUserName(String token) {
        DecodedJWT verify = verify(token);
        if (verify != null) {
            return verify.getClaim("username").asString();
        }
        return null;
    }

}
