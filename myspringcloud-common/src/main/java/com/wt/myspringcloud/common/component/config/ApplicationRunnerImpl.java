package com.wt.myspringcloud.common.component.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @author 文通
 * @since 2020/5/19
 */
@Component
public class ApplicationRunnerImpl implements ApplicationRunner {

    @Autowired
    private ApplicationArguments applicationArguments;

    @Override
    public void run(ApplicationArguments args) {
        System.out.println(applicationArguments);
        System.out.println(args);
        System.out.println("End");
    }
}
