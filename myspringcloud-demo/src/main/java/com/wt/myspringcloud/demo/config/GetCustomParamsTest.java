package com.wt.myspringcloud.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 测试注入属性受否成功
 *
 * @author 文通
 * @since 2020/5/19
 */
@Component
public class GetCustomParamsTest implements ApplicationRunner {

    @Autowired
    private CustomParams customParams;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(customParams);
    }

}
