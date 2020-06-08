package number;

import org.apache.commons.lang.StringUtils;

import java.util.Random;

/**
 * @author 文通
 * @since 2020/6/2
 */
public class RandomTest {

    public static void main(String[] args) {
        Random random = new Random();
        for (int i = 0; i < 1000; i++) {
            int rInt = random.nextInt(99999);
            String rString = String.valueOf(rInt);
            String r = StringUtils.leftPad(rString, 5, '0');
            System.out.println(r);
        }
    }
}
