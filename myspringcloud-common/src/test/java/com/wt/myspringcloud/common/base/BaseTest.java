package com.wt.myspringcloud.common.base;

import com.wt.myspringcloud.common.base.InterfaceDemo;

public class BaseTest implements InterfaceDemo {

    public static void main(String[] args) {
        BaseTest baseTest = new BaseTest();
        baseTest.play("Ou Minna" , (s) -> System.out.println(s + " is a lambda expression."));
    }

    @Override
    public void aMethod() {
        System.out.println("This is a abstract method form InterfaceDemo");
    }

    public void play(String s, FunctionalInterfaceDemo fid) {
        fid.show(s);
    }

}
