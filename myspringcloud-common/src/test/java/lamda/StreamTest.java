package lamda;

import java.util.*;
import java.util.stream.Stream;

/**
 * @author 文通
 * @since 2019/6/9
 */
public class StreamTest {

    public static void main(String[] args) {
        /*List<String> stringList = Arrays.asList("Hello", "World", "Java");
        stringList.sort(Comparator.comparingInt(String::length));
        // Function<接收 ? super String, 返回 ? extends String>
        stringList.sort(Comparator.comparing(e -> e.substring(1, 2)));
        stringList.stream().reduce();

        Stream<String> stringStream = Stream.of("Hello", "World", "Java");*/

        Optional<Integer> reduce = Stream.of(1, 2, 3).reduce(Integer::sum);
        System.out.println("使用 reduce 求和: " + reduce.get());

    }
}
