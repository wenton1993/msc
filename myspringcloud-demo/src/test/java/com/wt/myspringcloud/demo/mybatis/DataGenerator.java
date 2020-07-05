package com.wt.myspringcloud.demo.mybatis;

import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.mapper.MybatisDemoMapper;
import com.wt.myspringcloud.demo.pojo.entity.MybatisDemo;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author 文通
 * @since 2020/6/26
 */
public class DataGenerator extends BaseTest {

    @Resource
    protected MybatisDemoMapper mapper;

    /**
     * 生成数据
     */
    @Before
    public void before() {
        MybatisDemo demo = new MybatisDemo();
        for (int i = 0; i < 100; i++) {
            demo.setId(null);
            demo.setDemoNo(String.valueOf(i));// 0..99
            demo.setCustName("文通" + i);
            demo.setCustAge(RandomUtils.nextInt(18, 30));// 年龄:18-30
            demo.setCreateDatetime(LocalDateTime.now().minusDays(RandomUtils.nextInt(0, 7)));// 创建日期:过去一周内
            demo.setDeleted(0);// 未删除
            demo.setVersion(new Timestamp(Instant.now().toEpochMilli()));
            mapper.insert(demo);
        }
    }

}
