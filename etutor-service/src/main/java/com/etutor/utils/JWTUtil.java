package com.etutor.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.etutor.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;

/**
 * @author ：Lion
 * @date ：2020/1/7 6:19 下午
 */
@Slf4j
public class JWTUtil {

    public static final long EXPIRE_TIME = 7 * 24 * 60 * 60 * 1000;
    /**
     * 加密秘钥 也可以用密码
     */
    private static final String TOKEN_SECRET = "etutor-token";

    /**
     * 签名生成
     * @param user 用户信息
     */
    public static String sign(UserDTO user) {
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("mobile", user.getPhone())
                    //.withAudience("")
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;

    }

    /**
     * 签名合法性的验证
     * @param token token
     */
    public static boolean verify(String token) {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            log.info("认证通过：");
            log.info("issuer: " + jwt.getIssuer());
            log.info("mobile: " + jwt.getClaim("mobile").asString());
            log.info("过期时间：" + jwt.getExpiresAt());
            return true;
        } catch (Exception e) {
            return false;
        }

    }


}
