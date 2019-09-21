package proxy.statical;

import proxy.TestRecordService;

/**
 * 实现在调用 MyLogService::print() 前后打印日志
 * @author 文通
 * @since 2019/9/12
 */
public class TestRecordProxy implements TestRecordService {

    private TestRecordService recordService;

    public TestRecordProxy(TestRecordService recordService) {
        this.recordService = recordService;
    }

    @Override
    public void record() {
        recordService.record();
        System.out.println("TestRecordProxy - record");
    }
}
