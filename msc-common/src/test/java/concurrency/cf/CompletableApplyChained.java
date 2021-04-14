package concurrency.cf;

import java.util.concurrent.CompletableFuture;

/**
 * 同步链式执行
 */
public class CompletableApplyChained {

    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0))
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work)
                        .thenApply(Machina::work);
        System.out.println(timer.duration());
    }

}
