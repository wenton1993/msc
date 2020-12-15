package com.wt.myspringcloud.mall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringCloudApplication
@EnableConfigurationProperties
@ComponentScan(basePackages = "com.wt.myspringcloud.common.component")
@ComponentScan(basePackages = "com.wt.myspringcloud.mall")
public class MallApplication {

    public static void main(String[] args) {
        SpringApplication.run(MallApplication.class, args);
    }

}
