package concurrency.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 读写锁
 *
 * @author 文通
 * @since 2020/9/16
 */
public class ReentrantReadWriteLockDemo {

    private int n = 0;

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private void read() {
        try {
            lock.readLock().lock();
            System.out.println("read n:" + n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    private void write() {
        try {
            lock.writeLock().lock();
            System.out.println("write n:" + ++n);
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantReadWriteLockDemo demo = new ReentrantReadWriteLockDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(demo::read).start();
        }
        for (int i = 0; i < 10; i++) {
            new Thread(demo::write).start();
        }
    }

}
