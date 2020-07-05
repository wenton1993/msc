package com.wt.myspringcloud.demo.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.mapper.MybatisDemoMapper;
import com.wt.myspringcloud.demo.pojo.entity.MybatisDemo;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author 文通
 * @since 2020/6/26
 */
public class UpdateTest extends DataGenerator {

    /**
     * 使用 QueryWrapper+Entity 更新
     */
    @Test
    public void updateWrapperTest() {
        MybatisDemo demo = mapper.selectOne(new QueryWrapper<MybatisDemo>()
                .lambda()
                .eq(MybatisDemo::getDemoNo, "4"));
        // where
        MybatisDemo queryEntity = new MybatisDemo();
        queryEntity.setId(demo.getId());
        queryEntity.setCustAge(null);
        Wrapper<MybatisDemo> wrapper = new QueryWrapper<>(queryEntity);
        // set
        MybatisDemo updateEntity = new MybatisDemo();
        updateEntity.setCustName("欧敏娜");
        // 执行
        mapper.update(updateEntity, wrapper);
        MybatisDemo newDemo = mapper.selectById(demo.getId());
        Assert.assertEquals("欧敏娜", newDemo.getCustName());
        Assert.assertEquals(demo.getCustAge(), newDemo.getCustAge());
    }

    /**
     * 使用 UpdateWrapper 更新
     */
    @Test
    public void updateWrapperTest2() {
        MybatisDemo demo = mapper.selectOne(new QueryWrapper<MybatisDemo>()
                .lambda()
                .eq(MybatisDemo::getDemoNo, "4"));
        // where
        MybatisDemo queryEntity = new MybatisDemo();
        queryEntity.setId(demo.getId());
        queryEntity.setCustAge(null);
        // set
        Wrapper<MybatisDemo> wrapper = new UpdateWrapper<>(queryEntity)
                .lambda()
                .set(MybatisDemo::getCustName, "欧敏娜")
                .set(MybatisDemo::getCustAge, null);

        // 执行
        mapper.update(null, wrapper);
        MybatisDemo newDemo = mapper.selectById(demo.getId());
        Assert.assertEquals("欧敏娜", newDemo.getCustName());
        Assert.assertNull(newDemo.getCustAge());
    }
}
