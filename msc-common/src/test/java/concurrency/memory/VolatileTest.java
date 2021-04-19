package concurrency.memory;

public class VolatileTest {

    private static int x = 0;

    private static volatile boolean v = false;

    public static void read() {
        System.out.println(x + " " + v);
    }

    public static void write () {
        if (v) {
            x = 0;
            v = false;
        } else {
            x = 1;
            v = true;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                while (true) {
                    read();
                    write();
                }
            }).start();
        }

        // Thread.sleep(10 * 1000);
    }

}
