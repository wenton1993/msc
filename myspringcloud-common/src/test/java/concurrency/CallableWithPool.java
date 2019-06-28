package concurrency;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author 文通
 * @since 2019/6/26
 */
public class CallableWithPool {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futureList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            futureList.add(executorService.submit(() -> {System.out.println("Callable"); return 1;}));
        }
        executorService.shutdown();
        System.out.println("End");
    }
}
