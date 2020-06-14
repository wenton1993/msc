package com.wt.myspringcloud.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.demo.pojo.entity.Menu;
import com.wt.myspringcloud.demo.pojo.resp.WtUserOrderVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<WtUser> {

    WtUser queryUser();

    WtUser queryUserById(@Param("id") Long id);

    WtUser queryUserById2(@Param("id") Long id);

    /**
     * 嵌套结果映射
     */
    List<WtUserOrderVo> queryUserOrder();

    List<Menu> queryMenu();

    /**
     * 测试[XML自定义分页]
     * 备注:
     * 1.参数顺序不能改变，IPage必须放在最前面
     */
    IPage<WtUser> mySelectPage(IPage<?> page, @Param("params") WtUser params);

    /**
     * 嵌套查询
     */
    List<WtUserOrderVo> queryUserOrder2();
}
