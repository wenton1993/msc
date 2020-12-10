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

        // groupingBy
        Map<Integer, List<String>> groupingBy = Stream.of("1", "2", "123", "1234", "5", "12").collect(Collectors.groupingBy(String::length));
        Map<Integer, List<String>> groupingBy2 = Stream.of("1", "2", "123", "1234", "5", "12")
                .parallel()// 并行处理时会调用 combiner
                .collect(
                        HashMap::new,
                        (m, e) -> {
                            if (!m.containsKey(e.length())) {
                                m.put(e.length(), new ArrayList<>());
                            }
                            m.get(e.length()).add(e);
                        },
                        // Map::putAll// 会覆原 List, 导致每个 List 只有一个元素
                        (m, m2) -> {
                            System.out.println("groupingBy2::combiner" + m);
                            m2.forEach((k, v) -> {
                                m.merge(k, v, (l, l2) -> {
                                    l.addAll(l2);
                                    return l;
                                });
                            });
                        }
                );

        // partitioningBy
        Map<Boolean, List<String>> partitioningBy = Stream.of("1", "2", "123", "1234", "5", "12").collect(Collectors.partitioningBy(e -> e.length() == 1));
        Map<Boolean, List<String>> partitioningBy2 = Stream.of("1", "2", "123", "1234", "5", "12")
                .parallel()// 并行处理时会调用 combiner
                .collect(
                        HashMap::new,
                        (m, e) -> {
                            Boolean key = e.length() == 1;
                            if (!m.containsKey(key)) {
                                m.put(key, new ArrayList<>());
                            }
                            m.get(key).add(e);
                        },
                        // Map::putAll// 会覆原 List, 导致每个 List 只有一个元素
                        (m, m2) -> {
                            System.out.println("groupingBy2::combiner" + m);
                            m2.forEach((k, v) -> {
                                m.merge(k, v, (l, l2) -> {
                                    l.addAll(l2);
                                    return l;
                                });
                            });
                        }
                );

        // toMap, 用 map 更方便
        Map<String, Integer> toMap = Stream.of("1", "2", "123", "1234", "5", "12").collect(Collectors.toMap(String::toString, String::length));
        Map<String, Integer> toMap2 = Stream.of("1", "2", "123", "1234", "5", "12").collect(
                HashMap::new,
                (m, e) -> {
                    m.put(e, e.length());
                },
                Map::putAll
        );

        System.out.println("End");
    }

}
