package concurrency.conflict;

/**
 * 这是一个 int 生成器的抽象父类。
 * @author 文通
 * @since 2019/11/11
 */
public abstract class IntGenerator {
    // 标识该生成器是否已经被取消
    private volatile boolean canceled = false;
    // 生成一个 int
    public abstract int next();
    // 取消生成器
    public void cancel() {
        canceled = true;
    }
    // 检查生成器是否被取消
    public boolean isCanceled() {
        return canceled;
    }
}
