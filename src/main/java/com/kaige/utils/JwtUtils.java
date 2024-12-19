package com.kaige.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.time.Duration;
import java.util.Date;

public final class JwtUtils {
    /**
     * 密钥
     */
    private static final String SECRET_KEY = "kaigeYyds";

    /**
     * 过期时间 2天
     */
    private static final Duration expireTime = Duration.ofHours(3);

    /**
     * 生成token
     * @return JWT
     */
    public static String generateToken(String username) {
        Date expireDate = new Date(System.currentTimeMillis() + expireTime.toMillis());
        return Jwts.builder()
                .setSubject(username) //将username存入token
                .setIssuedAt(new Date()) //设置token的签发时间
                .setExpiration(expireDate) //设置token的过期时间
               .signWith(SignatureAlgorithm.HS256, SECRET_KEY) //使用HS256算法和密钥对token进行签名
                .compact();
    }
    /**
     * 验证token
     * @param token JWT字符串
     * @return 解析成功返回 Claims，解析失败返回 null
     */
    public static Claims validateToken(String token) {
        if (StringUtils.isEmpty(token)){
            return null;
        }
        // Claims 包含了 token 的所有声明信息，签发时间，过期时间，以及存放的数据
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException e) {
            System.out.println("解析失败");
        }
        return claims;
    }

}
