package com.wt.myspringcloud.demo.runner;

import com.wt.myspringcloud.demo.pojo.entity.MybatisDemoEntity;
import com.wt.myspringcloud.demo.service.MybatisDemoEntityService;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 * @author 文通
 * @since 2020/7/7
 */
@Component
public class MybatisDemoDataRunner implements ApplicationRunner {

    @Autowired
    private MybatisDemoEntityService mybatisDemoEntityService;

    @Override
    public void run(ApplicationArguments args) {
        MybatisDemoEntity demo = new MybatisDemoEntity();
        for (int i = 1; i <= 100; i++) {
            demo.setId(null);
            demo.setDemoNo(String.valueOf(i));// i
            demo.setName("文通" + i);
            demo.setAge(RandomUtils.nextInt(18, 30));// 18..30
            demo.setCreateDatetime(LocalDateTime.now().minusDays(RandomUtils.nextInt(0, 7)));// 创建日期:过去一周内
            demo.setDeleted(0);// 未删除
            demo.setVersion(new Timestamp(Instant.now().toEpochMilli()));
            mybatisDemoEntityService.save(demo);
        }
    }

}
