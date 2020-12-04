package stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Optional;

/**
 * Optional<T> reduce(BinaryOperator<T> accumulator)
 * accumulator 累加器 - 接受两个参数, 返回一个结果
 */
public class ReduceTest {

    public static void main(String[] args) {

        System.out.println("Start");

        List<Integer> integerList = Lists.newArrayList(1, 2, 5, 3, 4);

        int sum = integerList.stream().mapToInt(Integer::intValue).sum();// 15
        Integer sum2 = integerList.parallelStream().peek(e -> System.out.println(Thread.currentThread())).reduce(1, Integer::sum);// 16
        Integer sum3 = integerList.parallelStream()/*.peek(e -> System.out.println(Thread.currentThread()))*/.reduce(0, Integer::sum, Integer::sum);// sum: 15, 多线程

        // min
        Optional<Integer> min = integerList.stream().min(Integer::compareTo);// 1
        Optional<Integer> min2 = integerList.stream()
                .reduce((a, b) -> {
                    return a.compareTo(b) < 0 ? a : b;
                });// 1


        System.out.println("End");

    }
}
