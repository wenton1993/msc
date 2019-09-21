package com.wt.myspringcloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.myspringcloud.common.pojo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    User queryUser();

    User queryUserById(@Param("id") Long id);

    User queryUserById2(@Param("id") Long id);
}
