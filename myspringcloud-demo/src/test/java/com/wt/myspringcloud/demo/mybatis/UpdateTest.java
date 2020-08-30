package com.wt.myspringcloud.demo.mybatis;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wt.myspringcloud.demo.BaseTest;
import com.wt.myspringcloud.demo.mapper.MybatisDemoEntityMapper;
import com.wt.myspringcloud.demo.pojo.entity.Demo;
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
        Demo demo = mapper.selectOne(new QueryWrapper<Demo>()
                .lambda()
                .eq(Demo::getId, "4"));
        // where
        Demo queryEntity = new Demo();
        queryEntity.setId(demo.getId());
        queryEntity.setAge(null);
        Wrapper<Demo> wrapper = new QueryWrapper<>(queryEntity);
        // set
        Demo updateEntity = new Demo();
        updateEntity.setName("欧敏娜");
        // 执行
        mapper.update(updateEntity, wrapper);
        Demo newDemo = mapper.selectById(demo.getId());
        Assert.assertEquals("欧敏娜", newDemo.getName());
        Assert.assertEquals(demo.getAge(), newDemo.getAge());
    }

    /**
     * 使用 UpdateWrapper 更新
     */
    @Test
    public void updateWrapperTest2() {
        Demo demo = mapper.selectOne(new QueryWrapper<Demo>()
                .lambda()
                .eq(Demo::getId, "4"));
        // where
        Demo queryEntity = new Demo();
        queryEntity.setId(demo.getId());
        queryEntity.setAge(null);
        // set
        Wrapper<Demo> wrapper = new UpdateWrapper<>(queryEntity)
                .lambda()
                .set(Demo::getName, "欧敏娜")
                .set(Demo::getAge, null);

        // 执行
        mapper.update(null, wrapper);
        Demo newDemo = mapper.selectById(demo.getId());
        Assert.assertEquals("欧敏娜", newDemo.getName());
        Assert.assertNull(newDemo.getAge());
    }
}
