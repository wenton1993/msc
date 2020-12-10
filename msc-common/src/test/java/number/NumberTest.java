package number;

import java.text.DecimalFormat;

/**
 * @author 文通
 * @since 2019/5/19
 */
public class NumberTest {

    public static void main(String[] args) {
        DecimalFormat myFormatter = new DecimalFormat("$###,###.##");
        String format = myFormatter.format(123456789.246);// $12,345,679.24
        System.out.println(format);
        System.out.println(Double.valueOf(123456789.246).toString());
        System.out.println(String.valueOf(123456789.246));
        System.out.println(String.format("I haven a %s.", "pen"));
    }
}
