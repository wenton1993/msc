package com.wt.myspringcloud.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.pojo.entity.MybatisDemo;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.Test;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 文通
 * @since 2020/6/14
 */
public class MybatisMapperTest extends BaseTest {

    @Resource
    private MybatisDemoMapper mapper;

    /**
     * 生成数据
     */
    @Before
    public void before() {
        MybatisDemo demo = new MybatisDemo();
        for (int i = 0; i < 100; i++) {
            demo.setId(null);
            demo.setDemoNo(String.valueOf(i));
            demo.setCustName("文通" + i);
            demo.setCustAge(RandomUtils.nextInt(18, 30));
            demo.setCreateDatetime(LocalDateTime.now().minusDays(RandomUtils.nextInt(0, 7)));
            demo.setDeleted(0);
            demo.setVersion(new Timestamp(Instant.now().toEpochMilli()));
            mapper.insert(demo);
        }
    }

    /**
     * 测试内容:
     * 1. 指定查询字段
     * 2. 指定时间条件
     */
    @Test
    public void selectTest() {
        List<MybatisDemo> demoList = mapper.selectList(new QueryWrapper<MybatisDemo>()
                .lambda()
                // 指定查询字段
                .select(MybatisDemo::getDemoNo, MybatisDemo::getCustName, MybatisDemo::getCustAge, MybatisDemo::getCreateDatetime)
                .eq(MybatisDemo::getCustAge, 18)
                // 指定时间条件
                .ge(MybatisDemo::getCreateDatetime, LocalDate.now().minusDays(3))
        );
        System.out.println("End");
    }

    /**
     * 通过分页来实现 rownum <= 1 的功能
     */
    @Test
    public void selectFirstOne() {
        // 设置分页条件, 每页 1 条, 当前页为 1
        Page<MybatisDemo> page = new Page<>();
        page.setSize(1);
        page.setCurrent(1);
        // 设置查询条件
        Wrapper<MybatisDemo> wrapper = new QueryWrapper<MybatisDemo>()
                .lambda()
                .eq(MybatisDemo::getCustAge, 18);
        // 查询数据库
        mapper.selectPage(page, wrapper);
        System.out.println("End");
    }

    /**
     * 使用 last("rownum <= 1") 限制返回的记录函数, 但是这里只对 Oracle 有效
     */
    @Test
    public void selectFirstOne2() {
        QueryWrapper<MybatisDemo> wrapper = new QueryWrapper<MybatisDemo>()
                .ge("create_datetime", LocalDateTime.now().minusDays(3))
                .last("rownum <= 1");
        mapper.selectList(wrapper);
        System.out.println("End");
    }

    @Test
    public void selectOneByNotId() {
        List<MybatisDemo> demoList = mapper.selectList(new QueryWrapper<MybatisDemo>()
                .lambda()
                .eq(MybatisDemo::getDemoNo, "4"));
        if (demoList.size() > 0) {
            System.out.println(demoList.get(0));
        }
    }

    @Test
    public void deleteLogically() {
        QueryWrapper<MybatisDemo> wrapper = new QueryWrapper<>();
        wrapper.eq("demo_no", "4");
        List<MybatisDemo> demoList = mapper.selectList(wrapper);
        if (demoList.size() > 0) {
            MybatisDemo demo = demoList.get(0);
            mapper.deleteById(demo.getId());// 删除时不会 delete, 而是 set delete=1
            MybatisDemo demo2 = mapper.selectById(demo.getId());// 查询时自动增加条件 delete=0
            System.out.println(demo2);
        }
    }

    /**
     * UpdateWrapper
     */
    @Test
    public void updateByNotId() {
        List<MybatisDemo> demoList = mapper.selectList(new QueryWrapper<MybatisDemo>()
                .lambda()
                .eq(MybatisDemo::getDemoNo, "4"));
        if (demoList.size() > 0) {
            MybatisDemo demo = demoList.get(0);
            System.out.println(demo);
            Wrapper<MybatisDemo> wragger = new UpdateWrapper<MybatisDemo>()
                    .lambda()
                    .eq(MybatisDemo::getDemoNo, demo.getDemoNo());
            MybatisDemo updateEntity = new MybatisDemo();
            updateEntity.setCustName("欧敏娜");
            mapper.update(updateEntity, wragger);
            MybatisDemo newDemo = mapper.selectById(demo.getId());
            System.out.println("newDemo");
        }

    }

    @Test
    public void updateByIdWithVersion() {
        QueryWrapper<MybatisDemo> wrapper = new QueryWrapper<>();
        wrapper.eq("demo_no", "4");
        List<MybatisDemo> demoList = mapper.selectList(wrapper);
        if (demoList.size() > 0) {
            MybatisDemo demo = demoList.get(0);
            System.out.println(demo.getVersion());
            for (int i = 0; i < 5; i++) {
                demo.setCustAge(i);
                // demo.setVersion(new Timestamp(Instant.now().toEpochMilli()));
                mapper.updateById(demo);
                System.out.println("version" + i + ":" + mapper.selectById(demo.getId()).getVersion());
            }
        }
    }

}
