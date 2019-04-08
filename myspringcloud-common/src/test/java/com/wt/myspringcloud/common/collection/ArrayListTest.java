package com.wt.myspringcloud.common.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayListTest
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("榴莲" + i);
        }
        list.add("榴莲" + 11);
    }
}