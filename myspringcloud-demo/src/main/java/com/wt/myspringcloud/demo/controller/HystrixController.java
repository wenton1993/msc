package com.wt.myspringcloud.demo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 文通
 * @since 2019/6/19
 */
@RestController
@RequestMapping("/HystrixController")
public class HystrixController {

    @PostMapping("/test")
    @HystrixCommand(fallbackMethod = "fallbackMethod")
    public void test() throws Exception {
        throw new Exception("发生异常: test");
    }

    private void fallbackMethod() {
        System.out.println("fallbackMethod");
    }
}
