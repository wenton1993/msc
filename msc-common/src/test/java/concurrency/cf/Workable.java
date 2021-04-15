package concurrency.cf;

import java.util.concurrent.CompletableFuture;

public class Workable {

    String id;
    final double duration;

    public Workable(String id, double duration) {
        this.id = id;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Workable[" + id + "]";
    }

    // 睡眠一段时间，输出id
    public static Workable work(Workable tt) {
        new Nap(tt.duration); // Seconds
        tt.id = tt.id + "W";
        System.out.println(tt);
        return tt;
    }

    // 返回一个定义了id和睡眠时间的任务
    public static CompletableFuture<Workable> make(String id, double duration) {
        return CompletableFuture
                // 定义任务
                .completedFuture(
                        new Workable(id, duration)
                )
                .thenApplyAsync(Workable::work);
    }

}
