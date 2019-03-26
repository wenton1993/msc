package com.wt.myspringcloud.common.base;

import java.util.Arrays;
import java.util.Comparator;

/**
 * LengthComparator
 */
public class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() - o2.length();
    }

    public static void main(String[] args) {
        String[] friends = {"Peter", "Mary", "Pablo"};
        Arrays.sort(friends, new LengthComparator());
        System.out.println(Arrays.toString(friends));
    }

}