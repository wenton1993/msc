package concurrency.example.mine;

import java.time.LocalTime;

/**
 * @author 文通
 * @since 2019/6/27
 */
public class Box {

    private String name;

    private boolean empty = true;

    public synchronized void put(String name) {
        System.out.println("put begin - " + LocalTime.now());
        if (this.empty) {
            // put a name
            System.out.println("put: " + name);
            this.name = name;
            this.empty = false;
            // 延长操作时间
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // wakes up threads
            notifyAll();
        } else {
            // wait a get
            try {
                System.out.println("put release the monitor - " + LocalTime.now());
                // release the monitor
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void get() {
        System.out.println("get begin - " + LocalTime.now());
        if (this.empty) {
            // get a name
            try {
                System.out.println("get release the monitor - " + LocalTime.now());
                // release the monitor
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            // wait a put
            System.out.println("get: " + name);
            this.name = null;
            this.empty = true;
            // 延长操作时间
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // wakes up threads
            notifyAll();
        }
    }
}
