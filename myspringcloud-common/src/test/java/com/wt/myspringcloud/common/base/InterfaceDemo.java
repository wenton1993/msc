package com.wt.myspringcloud.common.base;

/**
 * InterfaceDemo
 */
public interface InterfaceDemo {

    public static final int A = 1;

    default void play() {
        System.out.print("This is a default method.");
    }

    void shoot();
    
}