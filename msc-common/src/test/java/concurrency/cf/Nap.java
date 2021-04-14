package concurrency.cf;

import java.util.concurrent.TimeUnit;

/**
 * nap 小睡，打盹儿
 * <p>
 * 一颗安眠药。创建该对象时睡眠一段时间。
 */
public class Nap {

    // 秒
    public Nap(double t) {
        try {
            TimeUnit.MILLISECONDS.sleep((int) (1000 * t));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Nap(double t, String msg) {
        this(t);
        System.out.println(msg);
    }

}
