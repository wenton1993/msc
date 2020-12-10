package datetime;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

/**
 * 测试结果:
 *     1. 虽然可精确到纳秒,但是通过在Java中没有什么好办法获取到纳秒,只能获取到毫秒
 *
 * @author 文通
 * @since 2020/5/21
 */
public class TimestampTests {

    public static void main(String[] args) {
        Instant currentInstant = Instant.now();
        System.out.println("纳秒: " + currentInstant.getNano());
        System.out.println(currentInstant);
        Timestamp timestamp = Timestamp.from(Instant.now());
        System.out.println(timestamp);
    }
}
