package proxy.dynamic;

/**
 * @author 文通
 * @since 2019/9/12
 */
public class Runner {

    public static void main(String[] args) {
        TestUserHandler handler = new TestUserHandler(new TestUserImpl());
        TestUserService proxy = (TestUserService) handler.getTarget();
        proxy.query();
        proxy.update();

        System.out.println("End");
    }

}
