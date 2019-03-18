package com.wt.myspringcloud.common;

import org.junit.Test;

import java.text.Format;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;

public class TestAlgorithm extends BaseTest {

    @Test
    public void test() {
        LocalDate localDate = LocalDate.of(1992, 2, 2);
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDate.toString());
        System.out.println(localDateTime.toString());
    }

    @Test
    public void testArray() {
        int[] arr = {1, 2, 3, 4};
        int[] newArry = new int[arr.length + 1];
        int index = 2;// 要插入的位置
        for (int i = 0; i < arr.length; i++) {
            if (i == index) {
                newArry[i] = 0;// 插入0
                newArry[i + 1] = arr[i];
            } else if (i > index) {
                newArry[i + 1] = arr[i];
            } else {
                newArry[i] = arr[i];
            }
        }
        arr = newArry;
        System.out.println("开始打印数组");
        for (int i = 0; i < arr.length; i++) {
            System.out.println("arry[" + i + "]: " + arr[i]);
        }
    }

}
