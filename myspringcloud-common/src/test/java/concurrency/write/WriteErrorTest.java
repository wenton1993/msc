package concurrency.write;

/**
 * @author 文通
 * @since 2019/7/1
 */
public class WriteErrorTest {

    private volatile int count = 0;

    public void increase() {
        this.count ++;
    }

    public static void main(String[] args) throws InterruptedException {
        WriteErrorTest demo = new WriteErrorTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    demo.increase();
                }
                System.out.println(Thread.currentThread().getName() + " - count: " + demo.count);
            }).start();
        }
    }
}
