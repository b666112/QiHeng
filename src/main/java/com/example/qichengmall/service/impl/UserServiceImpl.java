package com.example.qichengmall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.qichengmall.entity.User;
import com.example.qichengmall.service.UserService;
import com.example.qichengmall.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
