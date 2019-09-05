package com.wt.myspringcloud.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.myspringcloud.common.pojo.entity.User;

public interface UserService extends IService<User> {

    User queryUser();

    User queryUserById(Long id);
}
