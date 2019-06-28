package concurrency.test;

/**
 * @author 文通
 * @since 2019/6/27
 */
public class Getter implements Runnable {

    private Demo demo;

    public Getter(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.getName();
    }
}
