package proxy.statical;

/**
 * MainTest
 */
public class Runner {

    public static void main(String[] args) {
        // 将被代理对象抓换成代理对象
        TestUserProxy proxy = new TestUserProxy(new TestUserImpl());
        // 执行代理对象的方法
        proxy.query();
    }

}