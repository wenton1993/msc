package concurrency.cf;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 可退出任务
 */
public class QuittableTask implements Runnable {

    final int id;

    private AtomicBoolean running = new AtomicBoolean(true);// 是否继续执行

    public QuittableTask(int id) {
        this.id = id;
    }

    public void quit() {
        running.set(false);
    }

    @Override
    public void run() {
        while (running.get())
            new Nap(0.1);// 睡眠一段时间
        System.out.print(id + " ");// 打印id
    }

}
