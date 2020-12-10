package com.wt.myspringcloud.common.base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * LocalDateTimeTest
 */
public class LocalDateTimeTest {

    public static void main(String[] args) {
        // 设置日期和时间
        LocalDateTime localDateTime = LocalDateTime.of(2019, 3, 25, 22, 8, 30);
        // 设置日期时间格式
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");// hh是12小时制
        // LocalDateTime -> String
        String dateTime = localDateTime.format(dtf);
        // String -> LocalDateTime
        LocalDateTime localDateTime2 = LocalDateTime.parse(dateTime, dtf);
        // 修改日期或时间
        localDateTime2 = localDateTime2.plusMonths(1L);
        System.out.println("DateTime: " + dateTime);
        System.out.println("DateTime2: " + localDateTime2.format(dtf));
    }

}