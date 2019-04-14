package concurrency;

import javax.swing.Timer;

/**
 * SimpleRunnableTest
 */
public class SimpleRunnableTest {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("Name :" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        
        Thread thread = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);

        thread.run();
        thread2.run();
        thread3.run();
    }

}