package com.mind_map.controller;

import javax.servlet.http.HttpServletRequest;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.mind_map.common.PassToken;
import com.mind_map.common.R;
import com.mind_map.entity.User;
import com.mind_map.service.UserService;
import com.mind_map.utils.JwtTokenUtils;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping(value = "/users")
public class UserController {
    @Autowired
    private UserService userService;
    /**
     * 登录处理
     * 登陆成功返回token给前台，之后每调一个接口都需要校验token之后有效
     */
    @PassToken
    @PostMapping("/login")
    public R<String> UserLogin(@RequestBody User user) {
        log.info("user login method");
        // 得到用户的账号密码
        String username = user.getUsername();
        String password = user.getPassword();
        // 查看是否存在账号/密码是否正确
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User one = userService.getOne(queryWrapper);
        if (one == null) {
            log.info("user not exist");
            return R.error("用户不存在");
        }
        if (one.getPassword().equals(password)) {
            // 生成token并返回
            String token = JwtTokenUtils.createToken(one);
//            Claims tokenBody = JwtTokenUtils.getTokenBody(token);
//            Integer id = (Integer) tokenBody.get("id");
            log.info("login success");
            return R.success(token);
        }

        log.info("login fail");
        return R.error("密码错误");
    }

    /**
     * 注册处理
     */
    @PassToken
    @PostMapping("/register")
    public R<String> UserRegister(@RequestBody User user) {
        log.info("user register method");
        // 得到用户的账号密码
        String username = user.getUsername();
        String password = user.getPassword();
        Integer id = user.getId();

        // 查看账号是否已存在
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        User one = userService.getOne(queryWrapper);

        if (one != null) {
            log.info("user has existed");
            return R.error("用户已存在");
        }
        userService.save(user);

        log.info("register success");
        return R.success("注册成功");
    }
}
