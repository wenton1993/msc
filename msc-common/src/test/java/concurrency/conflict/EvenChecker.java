package concurrency.conflict;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 这是一个用于检查偶数的任务。
 * @author 文通
 * @since 2019/11/11
 */
public class EvenChecker implements Runnable {
    // 生成器
    public IntGenerator generator;
    // 任务 id
    public final int id;
    // 构造器
    public EvenChecker(IntGenerator generator, int id) {
        this.generator = generator;
        this.id = id;
    }
    // 检查下一个 int 是不是偶数，如果不是偶数，则停止生成器。
    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            System.out.printf("id: " + id + ", ");
            if (val % 2 != 0) {
                System.out.println(val + " 不是偶数！");
                generator.cancel();
            } else {
                System.out.println(val);
            }
        }
    }
    public static void test(IntGenerator generator, int count) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            executorService.execute(new EvenChecker(generator, i));
        }
        // 预约在所有线程执行结束后关闭 ExecutorService，并且从现在开始不再创建新的任务
        executorService.shutdown();
    }
}
