package proxy.statical;

/**
 * 代理类
 */
public class TestUserProxy implements TestUserService {

    /**
     * 保存被代理对象
     */
    private TestUserService testLogService;

    /**
     * 根据被代理对象创建代理对象
     *
     * @param testLogService 被代理对象
     */
    public TestUserProxy(TestUserService testLogService) {
        this.testLogService = testLogService;
    }

    /**
     * 代理方法
     */
    @Override
    public void query() {
        before();
        testLogService.query();
        after();
    }

    /**
     * 在被代理方法之前执行
     */
    private void before() {
        System.out.println("代理 before");
    }

    /**
     * 在被代理方法之后执行
     */
    public void after() {
        System.out.println("代理 after");
    }

}
