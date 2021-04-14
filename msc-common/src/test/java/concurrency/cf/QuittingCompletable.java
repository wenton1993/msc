package concurrency.cf;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 创建多个线程睡眠一段时间后打印一个数字
 */
public class QuittingCompletable {

    public static void main(String[] args) {
        // 创建多个可退出的任务
        List<QuittableTask> tasks =
                IntStream.range(1, QuittingTasks.COUNT)
                        .mapToObj(QuittableTask::new)
                        .collect(Collectors.toList());
        List<CompletableFuture<Void>> cfutures =
                tasks.stream()
                        .map(CompletableFuture::runAsync)
                        .collect(Collectors.toList());
        new Nap(1);
        tasks.forEach(QuittableTask::quit);
        // 所有任务执行完成后, 逐个返回任务执行的结果
        cfutures.forEach(CompletableFuture::join);
    }

}
