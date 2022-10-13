package com.mind_map.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mind_map.entity.User;
import com.mind_map.mapper.UserMapper;
import com.mind_map.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
