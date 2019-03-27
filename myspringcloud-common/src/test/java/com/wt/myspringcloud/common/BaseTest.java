package com.wt.myspringcloud.common;

import com.wt.myspringcloud.common.base.InterfaceDemo;

public class BaseTest implements InterfaceDemo {

    public static void main(String[] args) {
        BaseTest baseTest = new BaseTest();
        System.out.println("你好");
    }

    @Override
    public void aMethod() {
        System.out.println("This is a abstract method form InterfaceDemo");
    }

}
