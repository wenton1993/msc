package com.wt.myspringcloud.common;

/**
 * 简单栈
 */
public class SimpleStack {

    private int[] stack; //数组
    private int stackPointer = 0;

    public void push(int i) {
        stack[stackPointer] = i;
        stackPointer++;
    }

    public int pop() {
        stackPointer--;
        if (stackPointer >= 0) {
            return stack[stackPointer];
        } else {
            stackPointer = 0;
            return 0;
        }
        
    }

}