package com.wt.myspringcloud.demo.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.mapper.MybatisDemoEntityMapper;
import com.wt.myspringcloud.demo.pojo.entity.MybatisDemoEntity;
import org.junit.Test;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author 文通
 * @since 2020/6/14
 */
public class QueryTest extends BaseTest {

    @Resource
    private MybatisDemoEntityMapper mapper;

    /**
     * 测试内容:
     * 1. 指定查询字段
     * 2. 指定时间条件
     */
    @Test
    public void selectTest() {
        List<MybatisDemoEntity> demoList = mapper.selectList(new QueryWrapper<MybatisDemoEntity>()
                .lambda()
                // 指定查询字段
                .select(MybatisDemoEntity::getDemoNo, MybatisDemoEntity::getName, MybatisDemoEntity::getAge, MybatisDemoEntity::getCreateDatetime)
                // 指定年龄条件
                .eq(MybatisDemoEntity::getAge, 18)
                // 指定时间条件
                .ge(MybatisDemoEntity::getCreateDatetime, LocalDate.now().minusDays(3))
        );
        System.out.println("End");
    }

    /**
     * 通过分页来实现 rownum <= 1 的功能
     */
    @Test
    public void selectFirstOne() {
        // 设置分页条件, 每页 1 条, 当前页为 1
        Page<MybatisDemoEntity> page = new Page<>();
        page.setSize(1);
        page.setCurrent(1);
        // 设置查询条件
        Wrapper<MybatisDemoEntity> wrapper = new QueryWrapper<MybatisDemoEntity>()
                .lambda()
                .eq(MybatisDemoEntity::getAge, 18);
        // 查询数据库
        mapper.selectPage(page, wrapper);
        System.out.println("End");
    }

    /**
     * 使用 last("rownum <= 1") 限制返回的记录函数, 但是这里只对 Oracle 有效
     */
    @Test
    public void selectFirstOne2() {
        QueryWrapper<MybatisDemoEntity> wrapper = new QueryWrapper<MybatisDemoEntity>()
                .ge("create_datetime", LocalDateTime.now().minusDays(3))
                .last("rownum <= 1");
        mapper.selectList(wrapper);
        System.out.println("End");
    }

    @Test
    public void selectOneByNotId() {
        List<MybatisDemoEntity> demoList = mapper.selectList(new QueryWrapper<MybatisDemoEntity>()
                .lambda()
                .eq(MybatisDemoEntity::getDemoNo, "4"));
        if (demoList.size() > 0) {
            System.out.println(demoList.get(0));
        }
    }

    @Test
    public void deleteLogically() {
        QueryWrapper<MybatisDemoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("demo_no", "4");
        List<MybatisDemoEntity> demoList = mapper.selectList(wrapper);
        if (demoList.size() > 0) {
            MybatisDemoEntity demo = demoList.get(0);
            mapper.deleteById(demo.getId());// 删除时不会 delete, 而是 set delete=1
            MybatisDemoEntity demo2 = mapper.selectById(demo.getId());// 查询时自动增加条件 delete=0
            System.out.println(demo2);
        }
    }

    /**
     * UpdateWrapper
     */
    @Test
    public void updateByNotId() {
        List<MybatisDemoEntity> demoList = mapper.selectList(new QueryWrapper<MybatisDemoEntity>()
                .lambda()
                .eq(MybatisDemoEntity::getDemoNo, "4"));
        if (demoList.size() > 0) {
            MybatisDemoEntity demo = demoList.get(0);
            System.out.println(demo);
            Wrapper<MybatisDemoEntity> wragger = new UpdateWrapper<MybatisDemoEntity>()
                    .lambda()
                    .eq(MybatisDemoEntity::getDemoNo, demo.getDemoNo());
            MybatisDemoEntity updateEntity = new MybatisDemoEntity();
            updateEntity.setName("欧敏娜");
            mapper.update(updateEntity, wragger);
            MybatisDemoEntity newDemo = mapper.selectById(demo.getId());
            System.out.println("newDemo");
        }

    }

    @Test
    public void updateByIdWithVersion() {
        QueryWrapper<MybatisDemoEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("demo_no", "4");
        List<MybatisDemoEntity> demoList = mapper.selectList(wrapper);
        if (demoList.size() > 0) {
            MybatisDemoEntity demo = demoList.get(0);
            System.out.println(demo.getVersion());
            for (int i = 0; i < 5; i++) {
                demo.setAge(i);
                // demo.setVersion(new Timestamp(Instant.now().toEpochMilli()));
                mapper.updateById(demo);
                System.out.println("version" + i + ":" + mapper.selectById(demo.getId()).getVersion());
            }
        }
    }

    @Test
    public void updateWrapperTest() {
        MybatisDemoEntity demo = mapper.selectById("4");
        // where
        MybatisDemoEntity queryEntity = new MybatisDemoEntity();
        queryEntity.setId(demo.getId());
        Wrapper<MybatisDemoEntity> wrapper = new QueryWrapper<>(queryEntity);
        // set
        MybatisDemoEntity updateEntity = new MybatisDemoEntity();
        updateEntity.setName("欧敏娜");
        // 执行
        /*demoMapper.update(updateEntity, wrapper);*/
        MybatisDemoEntity newDemo = mapper.selectById("4");
        System.out.println("End");
    }

}
