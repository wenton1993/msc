package com.wt.myspringcloud.web.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

/**
 * @author 文通
 * @since 2019/6/22
 */
@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean testFilter() {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(new TestFilter());
        filterRegistrationBean.setEnabled();
    }
}
