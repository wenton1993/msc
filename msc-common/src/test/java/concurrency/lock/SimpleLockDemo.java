package concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 简单使用 Lock 的加锁和解锁方法
 *
 * @author 文通
 * @since 2020/9/15
 */
public class SimpleLockDemo {

    private Lock lock = new ReentrantLock();

    public void methodA() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void methodB() {
        try {
            lock.lock();
            System.out.println(Thread.currentThread().getName() + " start");
            Thread.sleep(5000);
            System.out.println(Thread.currentThread().getName() + " end");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        SimpleLockDemo simpleLock = new SimpleLockDemo();
        Runnable a = simpleLock::methodA;
        Runnable b = simpleLock::methodB;

        new Thread(a).start();
        new Thread(a).start();
        new Thread(b).start();
        new Thread(b).start();
    }

}
