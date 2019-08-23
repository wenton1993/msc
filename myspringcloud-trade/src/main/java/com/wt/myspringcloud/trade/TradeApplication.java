package com.wt.myspringcloud.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringCloudApplication
// @ComponentScan(basePackages = "com.wt.myspringcloud.common.aspect")// 不起作用，而且还导致了别的问题
@EnableFeignClients(basePackages = {"com.wt.myspringcloud.common.feign.listener", "com.wt.myspringcloud.common.feign.user"})
public class TradeApplication {

    public static void main(String[] args) {
        SpringApplication.run(TradeApplication.class, args);
    }

}
