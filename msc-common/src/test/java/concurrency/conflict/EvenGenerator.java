package concurrency.conflict;

/**
 * 这是一个偶数生成器。
 *
 * @author 文通
 * @since 2019/11/11
 */
public class EvenGenerator extends IntGenerator {

    private int currentEvenValue = 0;

    @Override
    public int next() {
        ++currentEvenValue;
        ++currentEvenValue;
        return currentEvenValue;
    }

    public static void main(String[] args) {
        // 理想情况下会输出中间状态的奇数，但是实际上并没有发生，应该是现在的电脑对线程资源的分配没有那么零散了
        EvenChecker.test(new EvenGenerator(), 1000000);
    }
}
