package concurrency.test;

import concurrency.SynchronizedTest;

/**
 * @author 文通
 * @since 2019/6/27
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("main begin");
        Demo demo = new Demo();
        Setter setter = new Setter(demo);
        Getter getter = new Getter(demo);
        new Thread(setter).start();
        // new Thread(getter).start();
        demo.getName();
    }
}
