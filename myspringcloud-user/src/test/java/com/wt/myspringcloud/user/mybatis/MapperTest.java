package com.wt.myspringcloud.user.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.user.BaseTest;
import com.wt.myspringcloud.user.mapper.UserMapper;
import com.wt.myspringcloud.user.pojo.WtUserOrderVo;
import com.wt.myspringcloud.user.pojo.WtMenu;
import com.wt.myspringcloud.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author 文通
 * @since 2019/9/9
 */
public class MapperTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    /**
     * 测试Mapper.xml中的#{param}
     */
    @Test
    public void testQueryUserById() {
        System.out.println(userMapper.queryUserById(1L));
    }
    /**
     * 测试Mapper.xml中的${param}
     */
    @Test
    public void testQueryUserById2() {
        System.out.println(userMapper.queryUserById2(3L));
    }

    /**
     * 测试分页
     */
    @Test
    public void testQueryUserById3() {
        IPage<WtUser> userIPage = userMapper.selectPage(new Page<>(2L, 2L), null);
        // IPage<User> page1 = userService.page(page);
        userIPage.getRecords().forEach(System.out::println);
    }

    /**
     * 测试[嵌套结果映射]
     */
    @Test
    public void testQueryUserOrder() {
        List<WtUserOrderVo> userOrderVos = userMapper.queryUserOrder();
        userOrderVos.forEach(System.out::println);
    }

    /**
     * 测试[嵌套查询]
     */
    @Test
    public void testQueryUserOrder2() {
        List<WtUserOrderVo> userOrderVos = userMapper.queryUserOrder2();
        System.out.println("打断点查看结果");
    }

    /**
     * 测试 Mybatis 树形结构查询
     */
    @Test
    public void queryMenu() {
        List<WtMenu> menus = userMapper.queryMenu();
        System.out.println("打断点查看结果");
    }
}
