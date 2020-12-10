package concurrency.write;

/**
 * @author 文通
 * @since 2019/7/1
 */
public class WriteAndReadErrorErrorWithSynchronized {

    public int count = 0;

    public int increase() {
        synchronized (this) {
            this.count ++;
            return count;
        }
    }

    public static void main(String[] args) {
        WriteAndReadErrorErrorWithSynchronized demo = new WriteAndReadErrorErrorWithSynchronized();
        new Thread(() -> {
            while (true) {
                // read
                System.out.println("count: " + demo.count);
                Thread.yield();
            }
        }).start();
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
    }
}
