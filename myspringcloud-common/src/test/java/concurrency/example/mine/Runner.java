package concurrency.example.mine;

import com.wt.myspringcloud.common.constant.RandomName;

/**
 * @author 文通
 * @since 2019/6/27
 */
public class Runner {

    public static void main(String[] args) throws InterruptedException {
        Box box = new Box();
        new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                box.put(RandomName.getRandomName().name());
            }
        }).start();
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                box.get();
            }
        }).start();
    }
}
