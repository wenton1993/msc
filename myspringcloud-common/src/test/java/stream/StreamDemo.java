package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author 文通
 * @since 2020/5/23
 */
public class StreamDemo {

    public static void main(String[] args) {
        // 1. 使用 collect(toList()) 创建List
        // 功能：将多个字符串添加到一个List
        List<String> stringList = Stream.of("a", "b", "c")
                .collect(Collectors.toList());

        // 2. map，使用 map 操作将字符串转换为大写形式
        // 功能：将多个字符串的所有字母转换成大写
        List<String> upperCaseStringList = Stream.of("a", "b", "c")
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // 3. filter，过滤不符合条件的元素
        // 功能：过滤首字符不是数字的字符串
        List<String> beginningWithNumbers = Stream.of("a", "1abc", "abc1")
                .filter(value -> Character.isDigit(value.charAt(0)))
                .collect(Collectors.toList());

        // 4. flatMap
        // 功能：合并多个List为一个List
        List<Integer> together = Stream.of(Arrays.asList(1, 2), Arrays.asList(1, 3, 4))
                // .flatMap(numbers -> numbers.stream())
                .flatMap(Collection::stream)// 将多个List转换为多个Stream，并将多个Stream合并为为一个Stream
                .collect(Collectors.toList());// 最后对一个Stream做终结操作
        // 对比flatMap和map
        List<Stream<Integer>> collect = Stream.of(Arrays.asList(1, 2), Arrays.asList(1, 3, 4))
                // .flatMap(numbers -> numbers.stream())
                .map(Collection::stream)// 将多个List转换为多个Stream，=没有合并功能
                .collect(Collectors.toList());// 导致最后的结果是合成一个List<Stream>

        // 5. max和min
        // 功能：找最长的自负床
        Optional<String> max = Arrays.asList("你好", "你", "你好吗").stream()
                .max(Comparator.comparing(String::length));

        // 6. reduce
        // 功能：使用reduce求和
        Integer reduceSum = Stream.of(1, 2, 3, 4, 5)
                // .reduce(0, (a, b) -> a + b);//被简化的表达
                .reduce(0, Integer::sum);

        // 结束
        System.out.println("End");
    }
}
