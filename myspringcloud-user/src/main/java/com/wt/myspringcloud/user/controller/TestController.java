package com.wt.myspringcloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.UrlResource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author 文通
 * @since 2019/6/18
 */
@Configuration
@PropertySource(value = "${spring.profiles.active}/app.properties", encoding = "UTF-8")
@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private Environment environment;

    @PostMapping("/1")
    public void test1() {
        System.out.println("TestController::test1: " + environment.getProperty("myName"));
    }

}
