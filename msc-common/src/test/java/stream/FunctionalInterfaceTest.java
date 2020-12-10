package stream;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author 文通
 * @since 2019/6/5
 */
public class FunctionalInterfaceTest {

    public static void main(String[] args) {
        Consumer<Integer> consumer = i -> System.out.println(i);// 等同于 System.out::println
        Predicate<Integer> predicate = integer -> integer > 0;
        BinaryOperator<Integer> binaryOperator = (t, u) -> t + u;// 等同于 Integer::sum
    }
}
