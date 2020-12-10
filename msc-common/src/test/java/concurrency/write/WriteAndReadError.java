package concurrency.write;

/**
 * @author 文通
 * @since 2019/7/1
 */
public class WriteAndReadError {

    public volatile int count = 0;

    public static void main(String[] args) {
        WriteAndReadError demo = new WriteAndReadError();
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    // write
                    System.out.println(++ demo.count);
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
