package proxy.statical;

import proxy.TestLogService;

/**
 * 实现在调用 MyLogService::print() 前后打印日志
 * @author 文通
 * @since 2019/9/12
 */
public class TestLogProxy implements TestLogService {

    private TestLogService testLogService;

    public TestLogProxy(TestLogService testLogService) {
        this.testLogService = testLogService;
    }

    @Override
    public void print() {
        System.out.println("before print");
        testLogService.print();
        System.out.println("after print");
    }
}
