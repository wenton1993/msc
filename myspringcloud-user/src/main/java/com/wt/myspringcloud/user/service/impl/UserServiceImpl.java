package com.wt.myspringcloud.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.myspringcloud.common.entity.User;
import com.wt.myspringcloud.user.mapper.UserMapper;
import com.wt.myspringcloud.user.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
