package concurrency;

/**
 * @author 文通
 * @since 2019/6/26
 */
public class SynchronizedTest {

    private String name;

    public String getName() {
        synchronized (this) {
            System.out.println("getName: " + this.name);
            return this.name;
        }
    }

    public void setName(String name) {
        synchronized (this) {
            for (int i = 0; i < 10_000; i++) {
                System.out.println("setName::runing");
            }
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            this.name = name;
            System.out.println("setName: " + this.name);
        }
    }

    public static void main(String[] args) {
        System.out.println("main begin");
        SynchronizedTest object = new SynchronizedTest();
        new Thread(() -> {
            object.setName("wentong");
        }).start();
        // System.out.println(object.getName());// 不会等待获取锁释放，直接输出 null，咋回事？
        new Thread(() -> {
            System.out.println(object.getName());
        }).start();
    }
}
