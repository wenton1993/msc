package proxy.dynamic;

import proxy.TestImpl;
import proxy.TestLogService;
import proxy.TestRecordService;

/**
 * @author 文通
 * @since 2019/9/12
 */
public class Runner {

    public static void main(String[] args) {
        TestHandler proxy = new TestHandler(new TestImpl());
        System.out.println("代理日志");
        ((TestLogService) proxy.getTarget()).print();
        System.out.println("代理记录");
        ((TestRecordService) proxy.getTarget()).record();
    }
}
