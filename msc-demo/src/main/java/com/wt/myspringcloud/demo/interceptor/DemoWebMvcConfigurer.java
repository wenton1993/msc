package com.wt.myspringcloud.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 文通
 * @since 2020/1/29
 */
@Configuration
public class DemoWebMvcConfigurer implements WebMvcConfigurer {

    /**
     * 在处理请求的过程中增加拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new DemoInterceptor());
    }
}
