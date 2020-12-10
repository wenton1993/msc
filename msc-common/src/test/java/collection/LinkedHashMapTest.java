package collection;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LinkedHashMapTest
 */
public class LinkedHashMapTest {

    public static void main(String[] args) {
        // accessOrder = false 时, 映射按照插入顺序排列
        Map<String, Object> map = new LinkedHashMap<>();
        map.put("1", "first");
        map.put("2", "second");
        map.put("3", "third");

        System.out.println("insertion-order:");
        map.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });

        // accessOrder = true 时, 映射按照访问顺序排列
        Map<String, Object> map2 = new LinkedHashMap<>(16, 0.75f, true);
        map2.put("1", "first");
        map2.put("2", "second");
        map2.put("3", "third");
        // 每次调用 put 或 get 都会将受影响的元素从当前位置删除, 并放到链表的尾部
        System.out.println("access-order: ");
        map2.get("3");
        map2.put("1", "new first");
        map2.forEach((k, v) -> {
            System.out.println(k + ": " + v);
        });
    }
}