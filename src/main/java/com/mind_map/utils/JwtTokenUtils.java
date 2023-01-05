package com.mind_map.utils;

import com.mind_map.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTokenUtils {

    public static final String TOKEN_HEADER = "TOKEN";
    private static final String CLAIM_KEY_CREATED = "created";
    /**
     * 密钥key
     */
    private static final String SECRET = "jwtsecurit";

    /**
     * JWT的发行人
     */
    private static final String ISS = "yxd";

    /**
     * 自定义用户信息
     */
    private static final String ROLE_CLAIMS = "rol";

    /**
     * 过期时间是3600秒，既是1个小时
     */
    public static final long EXPIRATION = 3600L * 1000;

    /**
     * 根据用户名创建token
     *
     * @param user
     * @return
     */
    public static String createToken(User user) {
        //Jwt头，暂时没用
        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        Map<String, Object> claims = new HashMap<>();
        //自定义有效载荷部分
        claims.put("id", user.getId());
        claims.put("username", user.getUsername());
        return createToken(claims);
    }

    private static String createToken(Map<String, Object> claims) {
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS512, SECRET) // 使用HS512算法签名，SECRET为签名密钥
                .setIssuer(ISS) // jwt发行人
                .setClaims(claims) // 有效载荷
                .setIssuedAt(new Date()) // 设定签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION)) // token过期时间
                .compact();
    }

    /**
     * 从token获取用户名
     *
     * @param token
     * @return
     */
    public static String getUsername(String token) {
        return (String) getTokenBody(token).get("username");
    }

    /**
     * 从token获取id
     *
     * @param token
     * @return
     */
    public static Integer getId(String token) {
        return (Integer) getTokenBody(token).get("id");
    }

    /**
     * 是否已过期
     *
     * @param token
     * @return
     */
    public static boolean isExpiration(String token) {
        return getTokenBody(token).getExpiration().before(new Date());
    }

    /**
     * 从token中获得jwt中的负载
     *
     * @param token
     * @return
     */
    public static Claims getTokenBody(String token) {
        return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
    }

    /**
     * 验证token
     *
     * @param token
     * @return
     */
    public static boolean validateToken(String token) {
        return isExpiration(token) == false;
    }

    /**
     * 刷新token
     *
     * @param token
     * @return
     */
    public String refreashToken(String token) {
        //如果token已经过期，不支持刷新
        if (isExpiration(token)) {
            return null;
        }
        //获取荷载
        Claims claims = getTokenBody(token);
        //修改过期时间
        claims.put(CLAIM_KEY_CREATED, new Date());
        //根据荷载生成token
        return createToken(claims);
    }

}
