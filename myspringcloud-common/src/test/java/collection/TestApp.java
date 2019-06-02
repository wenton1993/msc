package collection;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.*;

/**
 * @author 文通
 * @since 2019/5/28
 */
public class TestApp {

    public static void main(String[] args) {
        // 初始化
        List<CollectionTest.Color> list = new ArrayList<>();
        list.add(CollectionTest.Color.YELLO);
        list.add(CollectionTest.Color.RED);
        list.add(CollectionTest.Color.WHITE);
        list.add(CollectionTest.Color.RED);

        // 创建 List 视图
        List<CollectionTest.Color> sublist = list.subList(0, list.size() - 2);

        List<CollectionTest.Color> sublist2 = list.subList(0, list.size() - 3);
        // 修改
        /*Iterator<CollectionTest.Color> iterator = sublist.iterator();
        iterator.next();
        iterator.remove();*/

        // sublist.remove(1);
        // sublist.add(1, CollectionTest.Color.YELLO);
        sublist.retainAll(sublist2);

        // 输出
        list.forEach(System.out::println);
        // sublist.forEach(System.out::println);

        /*Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(2, 2);
        map.put(3, 3);

        Set<Integer> integers = map.keySet();

        for (Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator(); it.hasNext(); ) {
            it.next();
            it.remove();
        }

        System.out.println(map.size());
        System.out.println(integers.size());*/
    }

}
