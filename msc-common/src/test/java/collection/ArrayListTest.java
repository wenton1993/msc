package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * ArrayListTest
 */
public class ArrayListTest {

    public static void main(String[] args) {
        System.out.println("Start");
        // 测试ArrayList<>()和新增元素
        /*List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add("榴莲" + i);
        }
        list.add("榴莲" + 11);*/

        // 测试new ArrayList<>(0)和新增元素
        List<Integer> integerList = new ArrayList<>(0);
        for (int i = 0; i < 11; i++) {
            integerList.add(i);
        }
        System.out.println("End");
    }
}