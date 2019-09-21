package com.wt.myspringcloud.trade;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringCloudApplication
@EnableFeignClients(basePackages = {"com.wt.myspringcloud.common.feign.stream", "com.wt.myspringcloud.common.feign.user"})
public class TestApplication {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    };

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
