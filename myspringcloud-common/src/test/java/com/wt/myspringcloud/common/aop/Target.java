package com.wt.myspringcloud.common.aop;

/**
 * Target
 */
public class Target implements InterfaceDemo {

    @Override
    public void execute() {
        System.out.println("正在执行");
    }

    @Override
    public void execute(String name) {
        System.out.println("正在执行: " + name);
    }

}