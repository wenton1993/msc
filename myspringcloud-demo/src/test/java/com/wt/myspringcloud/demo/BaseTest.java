package com.wt.myspringcloud.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    // 检查测试类是否能够正常运行
    @Test
    public void test() {
        System.out.println("Hello!");
    }
}