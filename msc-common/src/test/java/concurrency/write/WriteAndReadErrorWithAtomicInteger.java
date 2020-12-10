package concurrency.write;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 文通
 * @since 2019/7/1
 */
public class WriteAndReadErrorWithAtomicInteger {

    private AtomicInteger count = new AtomicInteger(0);

    public int increase() {
        return this.count.incrementAndGet();
    }

    public int getCount() {
        return this.count.get();
    }

    public static void main(String[] args) {
        WriteAndReadErrorWithAtomicInteger demo = new WriteAndReadErrorWithAtomicInteger();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    // write
                    System.out.println(demo.increase());
                    Thread.yield();
                }
                System.out.println("write end - " + Thread.currentThread().getName());
            }).start();
        }
        new Thread(() -> {
            while (true) {
                // read
                System.out.println("count: " + demo.count);
                Thread.yield();
            }
        }).start();
    }
}
