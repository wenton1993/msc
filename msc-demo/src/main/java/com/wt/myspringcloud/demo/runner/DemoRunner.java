package com.wt.myspringcloud.demo.runner;

import com.wt.myspringcloud.demo.config.CustomParams;
import com.wt.myspringcloud.demo.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * 在 SpringApplication 启动后执行 run 方法
 *
 * @author 文通
 * @since 2020/7/7
 */
@Slf4j
@Component
public class DemoRunner implements ApplicationRunner {

    @Autowired
    private CustomParams customParams;

    @Override
    public void run(ApplicationArguments args) {
        // 打印自定义属性
        log.info(customParams.toString());
    }

}
