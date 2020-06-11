package com.wt.myspringcloud.common.component.aspect;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wt.myspringcloud.common.util.JacksonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * Aspect注解将一个java类定义为切面类
 */
@Slf4j
@Component
@Aspect
public class LogAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * Pointcut定义一个切入点
     * 第一个*匹配所有的返回类型
     * ..匹配当前包和当前包下所有的子包
     * 第三个*匹配所有的类
     * 第死个*匹配所有的方法
     * (..)匹配方法中任意的参数
     */
    @Pointcut("execution(public * com.wt.myspringcloud.*.controller..*.*(..))")
    public void controllerMethod() {
    }

    @Before("controllerMethod()")
    public void doBefort(JoinPoint joinPoint) {
        if (Objects.isNull(joinPoint)) {
            return;
        }
        startTime.set(System.currentTimeMillis());
        //获取请求
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        try {
            log.info("请求路径: {}, 请求参数{}", request.getRequestURI(), JacksonUtils.getMapper().writeValueAsString(joinPoint.getArgs()));
        } catch (JsonProcessingException e) {
            log.warn("打印请求参数时发生异常");
        }
        // logger.info("TraceId: {}, SpanId: {}, URL: {}", request.getRequestURL(), request.getHeader("X-B3-TraceId"), request.getHeader("X-B3-SpanId"));
        // logger.info("HTTP_METHOD : " + request.getMethod());
        // logger.info("IP : " + request.getRemoteAddr());
        // logger.info("CLASS_METHOD : " + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        // logger.info("ARGS : " + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "controllerMethod()")
    public void doAfterReturning(Object ret) throws Throwable {
        log.info("响应时间(微秒): {}, 响应结果: {}", System.currentTimeMillis() - startTime.get(), ret);
    }
}