package com.wt.myspringcloud.common.aop;

/**
 * MainTest
 */
public class MainTest {

    public static void main(String[] args) {
        ProxyHandler handler = new ProxyHandler();
        InterfaceDemo target = (InterfaceDemo) handler.bind(new Target());
        target.execute();
        target.execute("OuMinna");
    }

}