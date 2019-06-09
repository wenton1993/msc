package lamda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author 文通
 * @since 2019/6/9
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Hello", "World", "Java");
        stringList.sort(Comparator.comparingInt(String::length));
        // Function<接收 ? super String, 返回 ? extends String>
        stringList.sort(Comparator.comparing(e -> e.substring(1, 2)));

        Stream<String> stringStream = Stream.of("Hello", "World", "Java");

    }
}
