package com.wt.myspringcloud.common.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * ProxyHandler
 */
public class ProxyHandler implements InvocationHandler {

    private Object target;

    // 绑定一个被代理对象,并返回一个代理对象
    public Object bind(Object object) {
        this.target = object;
        return Proxy.newProxyInstance(this.target.getClass().getClassLoader(), this.target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.print(this.target);
        System.out.print("." + method.getName() + "(");
        if (args != null) {
            for (int i = 0; i < args.length; i++) {
                System.out.print(args[i]);
                if (i < args.length -1) System.out.print(", ");
            }
        }
        System.out.println(")");
        return method.invoke(this.target, args);
    }

}