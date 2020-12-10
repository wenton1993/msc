package com.wt.myspringcloud.task.core;

import java.util.concurrent.ScheduledFuture;

/**
 * @author 文通
 * @since 2020/9/7
 */
public final class ScheduledTask {

    volatile ScheduledFuture<?> future;

    /**
     * 取消定时任务
     */
    public void cancel() {
        ScheduledFuture<?> future = this.future;
        if (future != null) {
            future.cancel(true);
        }
    }

}
