package number;

import org.apache.commons.lang3.RandomUtils;

/**
 * @author 文通
 * @since 2020/6/8
 */
public class RandomUtilsTest {

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            System.out.println(RandomUtils.nextInt(0, 10));
        }
    }
}
