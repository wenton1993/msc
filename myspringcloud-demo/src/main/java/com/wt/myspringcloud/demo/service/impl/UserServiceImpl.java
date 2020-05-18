package com.wt.myspringcloud.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.demo.mapper.UserMapper;
import com.wt.myspringcloud.demo.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, WtUser> implements UserService {
}
