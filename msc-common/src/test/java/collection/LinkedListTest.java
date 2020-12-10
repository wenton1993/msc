package collection;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * LinkedListTest
 */
public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.remove(0);
        System.out.println("main - end");
    }

}