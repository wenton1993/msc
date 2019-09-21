package com.wt.myspringcloud.user.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.pojo.entity.User;
import com.wt.myspringcloud.user.BaseTest;
import com.wt.myspringcloud.user.mapper.UserMapper;
import com.wt.myspringcloud.user.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;
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
        IPage<User> userIPage = userMapper.selectPage(new Page<>(2L, 2L), null);
        // IPage<User> page1 = userService.page(page);
        userIPage.getRecords().forEach(System.out::println);
    }
}
