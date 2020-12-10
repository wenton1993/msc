package concurrency.test;

/**
 * @author 文通
 * @since 2019/6/27
 */
public class Setter implements Runnable {

    private Demo demo;

    public Setter(Demo demo) {
        this.demo = demo;
    }

    @Override
    public void run() {
        demo.setName("wentong");
    }
}
