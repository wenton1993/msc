package com.wt.myspringcloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.myspringcloud.common.pojo.entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper extends BaseMapper<User> {

    User queryOne();

    User queryOneById(@Param("id") Long id);
}
