package com.wt.myspringcloud.user.mybatis;

import com.wt.myspringcloud.user.BaseTester;
import com.wt.myspringcloud.user.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 文通
 * @since 2020/1/28
 */
public class FirstCacheTester extends BaseTester {

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
