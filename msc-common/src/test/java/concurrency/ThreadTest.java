package concurrency;

import java.time.LocalTime;

/**
 * @author 文通
 * @since 2019/6/26
 */
public class ThreadTest {

    public static void main(String[] args) throws InterruptedException {
        // 实现 Runnable，支持中断线程
        Runnable runnable = () -> {
            for (int i = 0; i < 100_000; i++) {
                if (Thread.currentThread().isInterrupted()) {
                    return;
                }
                System.out.println("step: " + i + ", " + LocalTime.now());
            }
            System.out.println("Runnable End");
        };
        // 启动多个线程
        /*for (int i = 0; i < 3; i++) {
            System.out.println(i + ":");
            new Thread(runnable).start();
        }*/
        Thread t = new Thread(runnable);
        // 启动线程
        t.start();
        // main 线程睡眠 1 秒
        Thread.sleep(1000);
        // 请求中断线程
        t.interrupt();
    }
}
