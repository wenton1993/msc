package com.wt.myspringcloud.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.user.mapper.UserMapper;
import com.wt.myspringcloud.user.service.UserService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService, InitializingBean {

    public UserServiceImpl() {
        System.out.println("UserServiceImpl::UserServiceImpl");
    }

    // perform certain actions upon initialization and destruction a bean.
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("UserServiceImpl::afterPropertiesSet");
    }

    // 作用与 InitializingBean 相同, 但是用法更加时尚
    @PostConstruct
    private void init() {
        System.out.println("UserServiceImpl::init");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("UserServiceImpl::destroy");
    }
}
