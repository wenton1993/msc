package com.wt.myspringcloud.common.base;

import java.util.Arrays;

/**
 * ComparableDemo
 */
public class ComparableDemo implements Comparable<ComparableDemo> {

    private double salary;

    public ComparableDemo(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(ComparableDemo comparableDemo) {
        return Double.compare(this.salary, comparableDemo.salary);
    }

    public static void main(String[] args) {
        ComparableDemo[] comparableDemos = {new ComparableDemo(2.1), new ComparableDemo(1.5), new ComparableDemo(2.0)};
        Arrays.sort(comparableDemos);
        for(ComparableDemo comparableDemo : comparableDemos) {
            System.out.println(comparableDemo.salary);
        }
    }

}