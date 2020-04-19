package com.wt.myspringcloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.user.pojo.UserOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<WtUser> {

    WtUser queryUser();

    WtUser queryUserById(@Param("id") Long id);

    WtUser queryUserById2(@Param("id") Long id);

    List<UserOrder> queryUserOrder();
}
