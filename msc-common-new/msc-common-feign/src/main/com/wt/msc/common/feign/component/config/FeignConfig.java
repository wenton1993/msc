package com.wt.msc.common.feign.component.config;

import feign.Feign;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * 防止 SpringMVC 将 @FeignClient 接口当作 @RequestMapping 接口加载，导致报错
 *
 * @author 文通
 * @since 2020/9/13
 */
@Configuration
@ConditionalOnClass({Feign.class})
@EnableFeignClients
public class FeignConfig {

    @Bean
    public WebMvcRegistrations feignWebRegistrations() {
        return new MyWebMvcRegistrations();
    }

    private static class MyWebMvcRegistrations implements WebMvcRegistrations {
        @Override
        public RequestMappingHandlerMapping getRequestMappingHandlerMapping() {
            return new FeignRequestMappingHandlerMapping();
        }
    }

    private static class FeignRequestMappingHandlerMapping extends RequestMappingHandlerMapping {
        @Override
        protected boolean isHandler(Class<?> beanType) {
            return super.isHandler(beanType) && !AnnotatedElementUtils.hasAnnotation(beanType, FeignClient.class);
        }
    }

}
