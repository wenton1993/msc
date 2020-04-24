package com.wt.myspringcloud.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.user.mapper.UserMapper;
import com.wt.myspringcloud.user.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, WtUser> implements UserService {
}
