package com.wt.myspringcloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.user.pojo.UserOrder;
import com.wt.myspringcloud.user.pojo.WtMenu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<WtUser> {

    WtUser queryUser();

    WtUser queryUserById(@Param("id") Long id);

    WtUser queryUserById2(@Param("id") Long id);

    List<UserOrder> queryUserOrder();

    List<WtMenu> queryMenu();

    /**
     * 测试[XML自定义分页]
     * 备注:
     *   1.参数顺序不能改变，IPage必须放在最前面
     */
    IPage<WtUser> mySelectPage(IPage<?> page, @Param("params") WtUser params);
}
