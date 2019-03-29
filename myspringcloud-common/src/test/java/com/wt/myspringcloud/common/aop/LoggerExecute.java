package com.wt.myspringcloud.common.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;

/**
 * LoggerExecute
 */
public class LoggerExecute implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("准备执行");
        invocation.proceed();
        return null;
    }

    public static void main(String[] args) {
        // 创建目标对象
        Target target = new Target();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new LoggerExecute());
        pf.setTarget(target);
        Target proxy = (Target) pf.getProxy();
        proxy.execute("代理执行");

    }

}