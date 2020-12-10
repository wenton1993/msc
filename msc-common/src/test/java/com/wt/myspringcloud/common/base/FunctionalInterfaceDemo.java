package com.wt.myspringcloud.common.base;

/**
 * FunctionalInterfaceDemo
 */
@FunctionalInterface
public interface FunctionalInterfaceDemo {

    public abstract void show(String s);

    public default void dMethod() {
        System.out.println("This is a default method.");
    }

}