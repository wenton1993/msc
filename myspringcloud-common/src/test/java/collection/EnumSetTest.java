package collection;

import java.time.DayOfWeek;
import java.util.EnumSet;
import java.util.LinkedList;

/**
 * @author 文通
 * @since 2019/5/28
 */
public class EnumSetTest {

    public static void main(String[] args) {
        EnumSet.range(DayOfWeek.MONDAY, DayOfWeek.FRIDAY).forEach(System.out::println);
        EnumSet.of(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY).forEach(System.out::println);
    }
}
