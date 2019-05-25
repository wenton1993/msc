package innerclass;

/**
 * @author 文通
 * @since 2019/5/21
 */
public class MyInnerClass {

    public void check(String key) {
        Checker checker = new Checker(key);
        checker.show();
    }

    public static class Checker {

        static String key;

        Checker(String key) {
            System.out.println("key: " + this.key);
            this.key = key;
        }

        void show() {
            System.out.println("key: " + this.key);
        }

    }

}
