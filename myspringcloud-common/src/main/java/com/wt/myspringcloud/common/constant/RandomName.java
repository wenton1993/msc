package com.wt.myspringcloud.common.constant;

import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

/**
 * @author 文通
 * @since 2019/6/16
 */
public enum RandomName {

    Alex, Alice, Alison,
    Bache, Bella,
    Carol, Cassie, Cristina,
    Dan, Daniel
    ;

    private static final List<RandomName> NAME_LIST = Arrays.asList(values());
    private static final Random RANDOM = new Random();
    // 获取一个随机的名字
    public static RandomName getRandomName()  {
        return NAME_LIST.get(RANDOM.nextInt(NAME_LIST.size()));
    }

    public static void main(String[] args) {
        /*RandomName randomName = RandomName.getRandomName();
        System.out.println(randomName.toString());*/
        GregorianCalendar gc = new GregorianCalendar();
        int year = 2032 + RANDOM.nextInt(6);
        gc.set(gc.YEAR, year);
        int dayOfYear = RANDOM.nextInt(gc.getActualMaximum(gc.DAY_OF_YEAR));


        for (int i = 0; i < 100; i++) {
            System.out.println(String.valueOf(2032 + RANDOM.nextInt(6)));
        }
    }
}
