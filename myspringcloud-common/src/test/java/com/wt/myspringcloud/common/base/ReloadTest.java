package com.wt.myspringcloud.common.base;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * ReloadTest
 */
public class ReloadTest {

    public static void play(HashMap hashmap) {
        System.out.println("play hashmap");
    }

    public static void play(Map map) {
        System.out.println("play map");
    }

    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        ReloadTest.play(hashMap);// show "paly hashmap"
        ReloadTest.play(treeMap);// shwo "play map"
    }

}