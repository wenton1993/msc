package com.wt.myspringcloud.demo.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.mapper.MybatisDemoEntityMapper;
import com.wt.myspringcloud.demo.pojo.entity.MybatisDemoEntity;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;

/**
 * @author 文通
 * @since 2020/6/26
 */
public class UpdateTest extends BaseTest {

    @Resource
    private MybatisDemoEntityMapper mapper;

    /**
     * 使用 QueryWrapper+Entity 更新
     */
    @Test
    public void updateWrapperTest() {
        MybatisDemoEntity demo = mapper.selectOne(new QueryWrapper<MybatisDemoEntity>()
                .lambda()
                .eq(MybatisDemoEntity::getDemoNo, "4"));
        // where
        MybatisDemoEntity queryEntity = new MybatisDemoEntity();
        queryEntity.setId(demo.getId());
        queryEntity.setAge(null);
        Wrapper<MybatisDemoEntity> wrapper = new QueryWrapper<>(queryEntity);
        // set
        MybatisDemoEntity updateEntity = new MybatisDemoEntity();
        updateEntity.setName("欧敏娜");
        // 执行
        mapper.update(updateEntity, wrapper);
        MybatisDemoEntity newDemo = mapper.selectById(demo.getId());
        Assert.assertEquals("欧敏娜", newDemo.getName());
        Assert.assertEquals(demo.getAge(), newDemo.getAge());
    }

    /**
     * 使用 UpdateWrapper 更新
     */
    @Test
    public void updateWrapperTest2() {
        MybatisDemoEntity demo = mapper.selectOne(new QueryWrapper<MybatisDemoEntity>()
                .lambda()
                .eq(MybatisDemoEntity::getDemoNo, "4"));
        // where
        MybatisDemoEntity queryEntity = new MybatisDemoEntity();
        queryEntity.setId(demo.getId());
        queryEntity.setAge(null);
        // set
        Wrapper<MybatisDemoEntity> wrapper = new UpdateWrapper<>(queryEntity)
                .lambda()
                .set(MybatisDemoEntity::getName, "欧敏娜")
                .set(MybatisDemoEntity::getAge, null);

        // 执行
        mapper.update(null, wrapper);
        MybatisDemoEntity newDemo = mapper.selectById(demo.getId());
        Assert.assertEquals("欧敏娜", newDemo.getName());
        Assert.assertNull(newDemo.getAge());
    }
}
