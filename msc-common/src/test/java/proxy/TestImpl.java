package proxy;

/**
 * Target
 */
public class TestImpl implements TestLogService, TestRecordService {

    @Override
    public void print() {
        System.out.println("TestImpl::print");
    }

    @Override
    public void record() {
        System.out.println("TestImpl::record");
    }
}