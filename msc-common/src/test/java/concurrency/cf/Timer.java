package concurrency.cf;

import static java.util.concurrent.TimeUnit.NANOSECONDS;

/**
 * 计时器
 */
public class Timer {

    private long start = System.nanoTime();

    public long duration() {
        return NANOSECONDS.toMillis(System.nanoTime() - start);
    }

    // 记录任务的执行时间
    public static long duration(Runnable test) {
        Timer timer = new Timer();
        test.run();
        return timer.duration();
    }

}
