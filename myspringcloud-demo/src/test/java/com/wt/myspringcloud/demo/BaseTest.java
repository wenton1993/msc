package com.wt.myspringcloud.demo;

import com.wt.myspringcloud.common.constant.RandomName;
import com.wt.myspringcloud.demo.pojo.entity.Demo;
import com.wt.myspringcloud.demo.service.DemoService;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    @Resource
    private DemoService demoService;

    // 检查测试类是否能够正常运行
    @Test
    public void test() {
        System.out.println("Hello!");
    }

    @Test
    public void initialize() {
        Demo demo = new Demo();
        for (int i = 1; i <= 100; i++) {
            demo.setId(null);
            demo.setName(RandomName.getRandomName().toString());
            demo.setAge(RandomUtils.nextInt(18, 30));// 18..30
            demo.setCreateDatetime(LocalDateTime.now().minusDays(RandomUtils.nextInt(0, 7)));// 创建日期:过去一周内
            demoService.save(demo);
        }
    }
}