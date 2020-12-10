package concurrency.example;

/**
 * @author 文通
 * @since 2019/6/27
 */
public class Runner {

    public static void main(String[] args) {
        Drop drop = new Drop();
        new Thread(new Producer(drop)).start();
        new Thread(new Producer(drop)).start();
        new Thread(new Consumer(drop)).start();
    }
}
