package com.wt.myspringcloud.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wt.myspringcloud.common.pojo.entity.WtUser;

public interface UserService extends IService<WtUser> {

    WtUser queryUser();

    WtUser queryUserById(Long id);
}
