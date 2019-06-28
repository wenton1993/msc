package concurrency;

/**
 * @author 文通
 * @since 2019/6/27
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("main begin");
        SynchronizedTest object = new SynchronizedTest();
        new Thread(() -> {
            object.setName("wentong");
        }).start();
        new Thread(() -> {
            System.out.println(object.getName());
        }).start();
        // System.out.println(object.getName());
    }
}
