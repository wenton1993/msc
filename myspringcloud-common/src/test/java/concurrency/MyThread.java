package concurrency;

/**
 * MyThread
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Hello!");
    }

    public static void main(String[] args) {
        MyThread t = new MyThread();
        t.start();
    }
    
}