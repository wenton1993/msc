package com.wt.myspringcloud.demo.interceptor;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 拦截器，打印一些无用的信息。
 *
 * @author 文通
 * @since 2020/1/29
 */
@Slf4j
public class DemoInterceptor implements HandlerInterceptor {

    /**
     * 处理前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("DemoInterceptor::preHandle, {}", request.toString());
        return true;
    }

    /**
     * 返回前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        log.info("DemoInterceptor::postHandle, {}", response.toString());
    }

    /**
     * 返回后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        log.info("DemoInterceptor::afterCompletion");
    }
}
