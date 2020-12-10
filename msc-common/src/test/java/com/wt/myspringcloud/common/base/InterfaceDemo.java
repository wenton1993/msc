package com.wt.myspringcloud.common.base;

/**
 * InterfaceDemo
 */
public interface InterfaceDemo {

    public static final int A = 1;

    public abstract void aMethod();

    public default void dMethod() {
        System.out.print("This is a default method.");
    };

    public static void sMethod() {
        System.out.print("This is a static method.");
    }
    
}