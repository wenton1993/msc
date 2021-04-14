package concurrency.cf;

import java.util.concurrent.CompletableFuture;

public class CompletableApplyAsync {

    Timer timer = new Timer();

    public static void main(String[] args) {
        Timer timer = new Timer();
        CompletableFuture<Machina> cf =
                CompletableFuture.completedFuture(
                        new Machina(0))
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work)
                        .thenApplyAsync(Machina::work);
        System.out.println(timer.duration());
        System.out.println(cf.join());
        System.out.println(timer.duration());
    }

}
