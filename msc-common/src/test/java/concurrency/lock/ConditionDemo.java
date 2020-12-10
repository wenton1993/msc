package concurrency.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 文通
 * @since 2020/9/16
 */
public class ConditionDemo {

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    public void await() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " await");
            // 当前线程自动释放该 Condition 对应的锁
            condition.await();

            System.out.println(Thread.currentThread().getName() + " do something");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " unlock");
            lock.unlock();
        }
    }

    public void signal() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " signal");
            // 调用该方法的线程, 必须持有该 Condition 的锁, 否则会发生异常 IllegalMonitorStateException
            condition.signal();

            System.out.println(Thread.currentThread().getName() + " sleep");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + " unlock");
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ConditionDemo demo = new ConditionDemo();
        Runnable await = demo::await;
        Runnable signal = demo::signal;
        new Thread(await).start();
        Thread.sleep(5000);
        new Thread(signal).start();
    }

}
