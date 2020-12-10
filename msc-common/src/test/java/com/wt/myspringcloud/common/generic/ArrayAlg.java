package com.wt.myspringcloud.common.generic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * ArrayAlg
 */
public class ArrayAlg {

    public static <T> T getMid(T... a) {
        return a[a.length / 2];
    }

    public static void main(String[] args) {
        System.out.println(ArrayAlg.<String>getMid("John", "Hello", "OuMinna"));
        System.out.println(ArrayAlg.<Double>getMid(3.14D, 17729D, 0D));
    }
    
}