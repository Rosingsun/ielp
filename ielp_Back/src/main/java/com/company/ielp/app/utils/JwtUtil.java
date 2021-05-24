package com.company.ielp.app.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.Claim;
import lombok.extern.slf4j.Slf4j;

import java.util.Calendar;
import java.util.Date;

/**
 * Jwt验证工具类
 * @author 幕冬
 */
@Slf4j
public class JwtUtil {


    /**
     * 根据用户id创建token
     * @param userId 用户id
     * @return token信息
     */
    public static String createToken(Integer userId) {

        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expiresDate = nowTime.getTime();

        return JWT.create()
                .withAudience(String.valueOf(userId))           //签发对象
                .withIssuedAt(new Date())       //发行时间
                .withExpiresAt(expiresDate)     //有效时间
                .sign(Algorithm.HMAC256(userId+"ielp"));   //加密

    }

    /**
     * 验证token
     * @param token token信息
     * @param userId 用户id
     */
    public static boolean verifyToken(String token, Integer userId) {
        // 这一步可以获取声明的信息，但验证就不用于……这不二楼
//        DecodedJWT jwt;
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(userId+"ielp")).build();
            verifier.verify(token);

            return true;

        } catch (Exception e) {
            return false;
        }
    }


    /**
     * 通过token获取签发对象，这里指用户id
     * @param token token信息
     * @return 签发对象信息
     */
    public static Integer getAudience(String token) {
        String audience;
        try {
            audience = JWT.decode(token).getAudience().get(0);
        } catch (JWTDecodeException j) {
            //这里是token解析失败
            j.printStackTrace();
            return null;
        }
        return Integer.parseInt(audience);
    }

    /**
     * 获取token中负载信息
     * @param token token信息
     * @param name 负载信息名称
     * @return 负载内容
     */
    public static Claim getClaimByName(String token, String name){
        return JWT.decode(token).getClaim(name);
    }

}
