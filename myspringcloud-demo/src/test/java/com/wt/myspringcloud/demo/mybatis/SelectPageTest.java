package com.wt.myspringcloud.demo.mybatis;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.common.pojo.entity.WtUser;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.mapper.UserMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author 文通
 * @since 2020/4/24
 */
public class SelectPageTest extends BaseTest {

    @Autowired
    private UserMapper userMapper;

    /**
     * 测试[MybatisPlus自带分页]
     */
    @Test
    public void testSelectPage() {
        IPage<WtUser> page1 = new Page<>(1L, 2L);
        page1 = userMapper.selectPage(page1, null);
        IPage<WtUser> page2 = new Page<>(1L, 2L);
        page2 = userMapper.selectPage(page2, null);
        IPage<WtUser> page3 = new Page<>(1L, 2L);
        page3 = userMapper.selectPage(page3, null);
        System.out.println("End");
    }

    /**
     * 测试[XML自定义分页]
     * 备注：
     *   1.分页传入的对象与返回的对象最好是同一个
     */
    @Test
    public void testSelectPage2() {
        WtUser params = new WtUser(null, "Test", null);
        // 查询第一页
        IPage<WtUser> page1 = new Page<>(1L, 2L);
        page1 = userMapper.mySelectPage(page1, params);
        // 查询第二页
        IPage<WtUser> page2 = new Page<>(2L, 2L);
        page2 = userMapper.mySelectPage(page2, params);
        // 查询第三页
        IPage<WtUser> page3 = new Page<>(3L, 2L);
        page3 = userMapper.mySelectPage(page3, params);
        // 再次查询第3页，测试分页传入和返回的对象不同的情况
        IPage<WtUser> anotherPage3 = new Page<>(3, 2L);
        IPage<WtUser> newPage3 = userMapper.mySelectPage(anotherPage3, params);
        System.out.println("End");
    }
}
