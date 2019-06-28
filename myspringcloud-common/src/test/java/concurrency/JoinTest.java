package concurrency;

import java.time.LocalTime;

/**
 * @author 文通
 * @since 2019/6/26
 */
public class JoinTest {

    public static void main(String[] args) {
        // 实现 Runnable
        Runnable runnable = () -> {
            for (int i = 0; i < 3; i++) {
                System.out.println("step: " + i + ", " + LocalTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return;
                }
            }
        };
        // join 线程
        Thread t = new Thread(runnable);
        t.start();
        // 不使用 join 的话，程序会直接打印出 "main end"
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
