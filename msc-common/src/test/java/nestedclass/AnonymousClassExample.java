package nestedclass;

/**
 * 匿名类
 *
 * @author 文通
 * @since 2019/7/11
 */
public class AnonymousClassExample {

    interface HelloWorld {
        public void greet();

        public void greetSomeone(String someone);
    }

    public void sayHello() {
        // 匿名类
        HelloWorld frenchGreeting = new HelloWorld() {
            String name = "tout le monde";

            public void greet() {
                greetSomeone("tout le monde");
            }

            public void greetSomeone(String someone) {
                name = someone;
                System.out.println("Salut " + name);
            }
        };

        frenchGreeting.greetSomeone("Fred");
    }

    public static void main(String... args) {
        AnonymousClassExample myApp = new AnonymousClassExample();
        myApp.sayHello();
    }
}
