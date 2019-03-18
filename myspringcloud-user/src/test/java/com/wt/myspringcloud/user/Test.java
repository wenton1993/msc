package com.wt.myspringcloud.user;

import com.wt.myspringcloud.common.entity.User;
import com.wt.myspringcloud.user.mapper.UserMapper;
import com.wt.myspringcloud.user.service.UserService;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Test {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @org.junit.Test
    public void testMapper() {
        System.out.println(("----- selectAll method test ------"));
        List<User> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }

    @org.junit.Test
    public void testService() {
        System.out.println(("----- selectAll method test ------"));
        User user = userService.getById(1);
        System.out.printf(user.getName());
    }

}
