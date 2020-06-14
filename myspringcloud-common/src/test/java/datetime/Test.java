package datetime;

import java.time.LocalDate;

/**
 * @author 文通
 * @since 2020/6/13
 */
public class Test {

    public static void main(String[] args) {
        // 今年-往前两年-第一天
        System.out.println(LocalDate.now().minusYears(2L).withDayOfYear(1));
    }
}
