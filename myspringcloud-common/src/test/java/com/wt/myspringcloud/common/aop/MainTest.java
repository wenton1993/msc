package com.wt.myspringcloud.common.aop;

import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.Comparator;
import java.util.ListIterator;

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