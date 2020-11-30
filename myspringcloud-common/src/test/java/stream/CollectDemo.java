package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 文通
 * @since 2020/11/30
 */
public class CollectDemo {

    public static void main(String[] args) {

        // toList
        List<Integer> list = Stream.of(1, 2, 3).collect(
                ArrayList::new,
                List::add,
                List::addAll
        );

        // toSet
        Set<Integer> set = Stream.of(1, 2, 3).collect(
                HashSet::new,
                Set::add,
                Set::addAll
        );

        // joining
        StringJoiner stringJoiner = Stream.of("Hello", "Nice", "Girl").collect(
                () -> new StringJoiner(", ", "", ""),
                StringJoiner::add,
                StringJoiner::merge
        );

        // mapping
        List<Integer> stringToIntegerList = Stream.of("1", "2", "3").collect(Collectors.mapping(Integer::valueOf, Collectors.toList()));
        List<Integer> stringToIntegerList2 = Stream.of("1", "2", "3").collect(
                ArrayList::new,
                (l, e) -> {
                    l.add(Integer.valueOf(e));
                },
                List::addAll
        );

        System.out.println("End");
    }

}
