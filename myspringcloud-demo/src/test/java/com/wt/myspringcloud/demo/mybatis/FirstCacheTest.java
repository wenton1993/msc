package com.wt.myspringcloud.demo.mybatis;

import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 文通
 * @since 2020/1/28
 */
public class FirstCacheTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    @Transactional
    public void test() {
        userMapper.queryUserById(1L);
        userMapper.queryUserById(2L);
        userMapper.queryUserById(1L);
    }
}
