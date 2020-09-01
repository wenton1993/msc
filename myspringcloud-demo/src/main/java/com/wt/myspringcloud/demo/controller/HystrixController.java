package com.wt.myspringcloud.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试熔断器
 *
 * @author 文通
 * @since 2019/6/19
 */
@Slf4j
@RestController
@RequestMapping("/HystrixController")
public class HystrixController {

    @PostMapping("/test")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public void test() throws Exception {
        throw new Exception("发生异常: test");
    }

    private void fallbackMethod() {
        log.warn("fallbackMethod");
    }
}
