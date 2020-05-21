package datetime;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

/**
 * @author 文通
 * @since 2020/5/18
 */
public class DateTimeDemo {

    public static void main(String[] args) {
        System.out.println("==== 默认精度 ====");
        System.out.println("LocalDateTime.now(): " + LocalDateTime.now());// 精确到毫秒
        System.out.println("Instant.now(): " + Instant.now());// 精确到毫秒
        System.out.println("new java.util.Date(): " + new Date());// 只展示到秒,但是精确到毫秒
        System.out.println("new java.util.Date(): " + new Date().toInstant());// 精确到毫秒

        System.out.println("==== Instant ====");
        System.out.println("起点时间：" + Instant.ofEpochSecond(0L));
        System.out.println("当前时间：" + Instant.now());
        System.out.println("计算时间偏移：" + Instant.now().plus(-3, ChronoUnit.DAYS));
        System.out.println("计算时间间隔：" + Instant.ofEpochSecond(0L).until(Instant.now(), ChronoUnit.DAYS));

        System.out.println("==== 带时区的Instant ====");
        System.out.println("设置时区：" + Instant.now().atZone(ZoneId.systemDefault()));
        System.out.println("设置时区后增减时间：" + Instant.now().atZone(ZoneId.systemDefault()).plus(3, ChronoUnit.YEARS));
        System.out.println("设置时区后增减时间：" + Instant.now().atZone(ZoneId.of("US/Arizona")).plus(3, ChronoUnit.YEARS));

        System.out.println("==== LocalDateTime ====");
        String localDateTimeString = "2020-05-18 11:11:11";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(localDateTimeString, dateTimeFormatter);
        System.out.println("解析时间字符串：" + localDateTime);
        System.out.println("时间格式化输出：" + localDateTime.format(DateTimeFormatter.ISO_DATE_TIME));
        System.out.println("偏移时间：" + LocalDateTime.now().plus(1, ChronoUnit.DAYS));
        System.out.println("转Instant：" + localDateTime.toInstant(OffsetDateTime.now().getOffset()));

        System.out.println("==== Date ====");
        System.out.println("Date转Instant：" + new Date().toInstant());
        System.out.println("Instant转Date：" + Date.from(Instant.now()));
        Date date = new Date();
        date.setTime(date.getTime() + 3 * 60 * 60 * 1000);// 后移动三小时
        System.out.println("偏移时间：" + date);

        System.out.println("==== ZoneId 与 ZoneOffset ====");
        System.out.println("系统默认时区：" + ZoneId.systemDefault());
        System.out.println("系统默认偏移时区：" + OffsetDateTime.now().getOffset());

        System.out.println("==== End ====");
    }
}
