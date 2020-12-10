package concurrency;

/**
 * @author 文通
 * @since 2019/7/9
 */
public class MainAndSubThread {

    private int count = 0;

    public int add() {
        this.count ++ ;
        return this.count;
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        MainAndSubThread demo = new MainAndSubThread();
        // 持续增加 count 的值
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("count: " + demo.add());
            }
        }).start();
        // 持续打印 count 的值
        new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sub: " + demo.getCount());
            }
        }).start();
        // 主线程秩序打印 count 的值
        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("main: " + demo.getCount());
        }
    }
}
