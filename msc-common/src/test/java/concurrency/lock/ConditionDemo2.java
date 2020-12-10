package concurrency.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 文通
 * @since 2020/9/16
 */
public class ConditionDemo2 {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private boolean flag = false;

    public void printZero() {
        try {
            lock.lock();
            while (!flag) {
                // 如果 flag = false, 打印 0 然后等待
                System.out.println(0);
                condition.await();
                // condition.await(30, TimeUnit.SECONDS);
            }
            // 如果 flag != false, 则赋值成 flase, 然后唤醒其它线程
            flag = false;
            // condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("0 " + Thread.currentThread().getName() + " unlock");
            lock.unlock();
        }
    }

    public void printOne() {
        try {
            lock.lock();
            while (flag) {
                // 如果 flag = true, 打印 1 然后等待
                System.out.println(1);
                condition.await();
                // condition.await(30, TimeUnit.SECONDS);
            }
            // 如果 flag != true, 则赋值成 true, 然后唤醒其它线程
            flag = true;
            // condition.signal();
            condition.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println("1 " + Thread.currentThread().getName() + " unlock");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo2 demo = new ConditionDemo2();
        Runnable printZero = demo::printZero;
        Runnable printOne = demo::printOne;
        for (int i = 0; i < 10; i++) {
            new Thread(printZero).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(printOne).start();
        }
    }

}
