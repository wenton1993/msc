package com.wt.myspringcloud.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringCloudApplication
// @ComponentScan(basePackages = "com.wt.myspringcloud.common.aspect")// 不起作用，而且还导致了别的问题
@EnableFeignClients(basePackages = {"com.wt.myspringcloud.common.feign.listener"})
@MapperScan("com.wt.myspringcloud.user.mapper")
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}
