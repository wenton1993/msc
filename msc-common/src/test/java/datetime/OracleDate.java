package datetime;

import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;

/**
 * @author 文通
 * @since 2020/5/21
 */
public class OracleDate {

    public static void main(String[] args) {
        Instant instant = Instant.now();
        Instant instant2 = Instant.now();
        instant2.atZone(ZoneId.systemDefault());
        System.out.println(new Date(instant.toEpochMilli()));
        System.out.println(new Date(instant2.toEpochMilli()));
    }

}
