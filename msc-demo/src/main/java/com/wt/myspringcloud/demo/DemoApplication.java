package com.wt.myspringcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// [Swagger配置]
@EnableSwagger2
@EnableConfigurationProperties
@EnableFeignClients
@ComponentScan(basePackages = "com.wt.myspringcloud.common.component")
@ComponentScan(basePackages = "com.wt.myspringcloud.demo")
@SpringCloudApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
