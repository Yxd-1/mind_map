package com.mind_map.interceptor;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.mind_map.common.PassToken;
import com.mind_map.common.UserLoginToken;
import com.mind_map.entity.User;
import com.mind_map.service.UserService;
import com.mind_map.utils.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * JWT验证拦截器
 */
@Slf4j
@Component
public class JWTInterceptor implements HandlerInterceptor {

    @Autowired
    UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("preHandle method");
        // 此处配置的是允许任意域名跨域请求，可根据需求指定
        response.setHeader("Access-Control-Allow-Origin", request.getHeader("origin"));
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, PATCH, DELETE, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "86400");
        response.setHeader("Access-Control-Allow-Headers", "*");

        // 如果是OPTIONS则结束请求
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return false;
        }

        // 从 http 请求头中取出 token
        String token = request.getHeader("token");
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //检查方法是否有passToken注解，有则跳过认证，直接通过
        if (method.isAnnotationPresent(PassToken.class)) {
            PassToken passToken = method.getAnnotation(PassToken.class);
            if (passToken.required()) {
                return true;
            }
        }

        //检查有没有需要用户权限的注解
        if (method.isAnnotationPresent(UserLoginToken.class)) {
            UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
            if (userLoginToken.required()) {
                // 执行认证
                if (token == null) {
                    throw new RuntimeException("无token，请重新登录");
                }
                // token是否过期
                if (JwtTokenUtils.isExpiration(token)) {
                    throw new RuntimeException("token已过期，请重新登录");
                }
                // 获取 token 中的 user id
                Integer id;
                try {
                    id = (Integer) JwtTokenUtils.getTokenBody(token).get("id");
                } catch (Exception e) {
                    throw new RuntimeException("token不正确，请不要通过非法手段创建token");
                }
                //查询数据库，看看是否存在此用户
                User user = userService.getById(id);
                if (user == null) {
                    throw new RuntimeException("用户不存在，请重新登录");
                }

                // 验证 token
                String username = (String) JwtTokenUtils.getTokenBody(token).get("username");
                if (!username.equals(user.getUsername())) {
                    throw new RuntimeException("token不正确，请重新登录");
                }
                return true;
            }
            return false;
        }
        throw new RuntimeException("没有权限注解一律不通过");
    }
}
