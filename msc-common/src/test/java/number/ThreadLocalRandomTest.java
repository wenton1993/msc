package number;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author 文通
 * @since 2020/6/2
 */
public class ThreadLocalRandomTest {

    public static void main(String[] args) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 1000; i++) {
            System.out.println(random.nextInt(10));
        }
    }
}
