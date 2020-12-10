package concurrency;

/**
 * @author 文通
 * @since 2019/9/4
 */
public class StringBuilderTest {

    public static void main(String[] args) throws InterruptedException {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    stringBuilder.append("a");
                }
                System.out.println(Thread.currentThread().getName() + " - end");// 打印 end 则表示该线程循环结束了
            }).start();
        }
        Thread.sleep(5000);
        System.out.println(stringBuilder.length());
    }
}
