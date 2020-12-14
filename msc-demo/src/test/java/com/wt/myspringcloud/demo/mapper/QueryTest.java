package com.wt.myspringcloud.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.pojo.entity.Demo;
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
    private DemoMapper mapper;

    /**
     * 测试内容:
     * 1. 指定查询字段
     * 2. 指定时间条件
     */
    @Test
    public void selectTest() {
        List<Demo> demoList = mapper.selectList(new QueryWrapper<Demo>()
                .lambda()
                // 指定查询字段
                .select(Demo::getId, Demo::getName, Demo::getAge, Demo::getCreateDatetime)
                // 指定年龄条件
                .eq(Demo::getAge, 18)
                // 指定时间条件
                .ge(Demo::getCreateDatetime, LocalDate.now().minusDays(3))
        );
        System.out.println("End");
    }

    /**
     * 通过分页来实现 rownum <= 1 的功能
     */
    @Test
    public void selectFirstOne() {
        // 设置分页条件, 每页 1 条, 当前页为 1
        Page<Demo> page = new Page<>();
        page.setSize(1);
        page.setCurrent(1);
        // 设置查询条件
        Wrapper<Demo> wrapper = new QueryWrapper<Demo>()
                .lambda()
                .eq(Demo::getAge, 18);
        // 查询数据库
        mapper.selectPage(page, wrapper);
        System.out.println("End");
    }

    /**
     * 使用 last("rownum <= 1") 限制返回的记录函数, 但是这里只对 Oracle 有效
     */
    @Test
    public void selectFirstOne2() {
        QueryWrapper<Demo> wrapper = new QueryWrapper<Demo>()
                .ge("create_datetime", LocalDateTime.now().minusDays(3))
                .last("rownum <= 1");
        mapper.selectList(wrapper);
        System.out.println("End");
    }

    @Test
    public void selectOneByNotId() {
        List<Demo> demoList = mapper.selectList(new QueryWrapper<Demo>()
                .lambda()
                .eq(Demo::getId, "4"));
        if (demoList.size() > 0) {
            System.out.println(demoList.get(0));
        }
    }

    @Test
    public void deleteLogically() {
        QueryWrapper<Demo> wrapper = new QueryWrapper<>();
        wrapper.eq("demo_no", "4");
        List<Demo> demoList = mapper.selectList(wrapper);
        if (demoList.size() > 0) {
            Demo demo = demoList.get(0);
            mapper.deleteById(demo.getId());// 删除时不会 delete, 而是 set delete=1
            Demo demo2 = mapper.selectById(demo.getId());// 查询时自动增加条件 delete=0
            System.out.println(demo2);
        }
    }

    /**
     * UpdateWrapper
     */
    @Test
    public void updateByNotId() {
        List<Demo> demoList = mapper.selectList(new QueryWrapper<Demo>()
                .lambda()
                .eq(Demo::getId, "4"));
        if (demoList.size() > 0) {
            Demo demo = demoList.get(0);
            System.out.println(demo);
            Wrapper<Demo> wragger = new UpdateWrapper<Demo>()
                    .lambda()
                    .eq(Demo::getId, demo.getId());
            Demo updateEntity = new Demo();
            updateEntity.setName("欧敏娜");
            mapper.update(updateEntity, wragger);
            Demo newDemo = mapper.selectById(demo.getId());
            System.out.println("newDemo");
        }

    }

    @Test
    public void updateByIdWithVersion() {
        QueryWrapper<Demo> wrapper = new QueryWrapper<>();
        wrapper.eq("demo_no", "4");
        List<Demo> demoList = mapper.selectList(wrapper);
        if (demoList.size() > 0) {
            Demo demo = demoList.get(0);
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
        Demo demo = mapper.selectById("4");
        // where
        Demo queryEntity = new Demo();
        queryEntity.setId(demo.getId());
        Wrapper<Demo> wrapper = new QueryWrapper<>(queryEntity);
        // set
        Demo updateEntity = new Demo();
        updateEntity.setName("欧敏娜");
        // 执行
        /*demoMapper.update(updateEntity, wrapper);*/
        Demo newDemo = mapper.selectById("4");
        System.out.println("End");
    }

}
