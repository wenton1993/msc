package com.wt.myspringcloud.common.base;

import java.time.LocalDateTime;
import java.util.Arrays;

import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 * LambdaTest
 * 在一个比较器和动作监听器中使用lambda表达式
 */
public class LambdaTest {

    public static void main(String[] args) {
        String[] strings = new String[] {"bcd", "d", "cd", "abcd"};
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
        System.out.println("Sorted by length:");
        Arrays.sort(strings, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(strings));

        Timer t = new Timer(5000, event -> System.out.println("DateTime:" + LocalDateTime.now()));
        t.start();
        JOptionPane.showMessageDialog(null, "OK");
        System.exit(0);
    }
    
}