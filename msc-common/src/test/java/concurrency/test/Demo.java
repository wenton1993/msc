package concurrency.test;

/**
 * @author 文通
 * @since 2019/6/27
 */
public class Demo {

    private String name;

    public String getName() {
        synchronized (this) {
            System.out.println("getName: " + this.name);
            return this.name;
        }
    }

    public void setName(String name) {
        synchronized (this) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.name = name;
            System.out.println("setName: " + this.name);
        }
    }
}
