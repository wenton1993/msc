package concurrency;

import java.util.concurrent.*;

/**
 * @author 文通
 * @since 2019/8/7
 */
public class ExecutorServiceDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        Callable<Integer> callable = () -> 1;

        Future<Integer> future = executorService.submit(callable);
        while (!future.isDone()) {
            System.out.println("Running");
        }
        System.out.println(future.get());
    }
}
