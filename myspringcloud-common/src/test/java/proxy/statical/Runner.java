package proxy.statical;

import proxy.TestImpl;

/**
 * MainTest
 */
public class Runner {

    public static void main(String[] args) {
        TestImpl target = new TestImpl();
        System.out.println("创建日志代理");
        TestLogProxy logProxy = new TestLogProxy(target);
        logProxy.print();
        System.out.println("创建记录代理");
        TestRecordProxy recordProxy = new TestRecordProxy(target);
        recordProxy.record();
    }
}