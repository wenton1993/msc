package com.wt.myspringcloud.common.collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedListTest
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        ListIterator iterator = list.listIterator();
        ListIterator iterator2 = list.listIterator();
        iterator.next();
        iterator.next();
        iterator.remove();// expectedModCount++
        iterator2.next();// throw ConcurrentModificationException
        iterator2.next();
    }

}