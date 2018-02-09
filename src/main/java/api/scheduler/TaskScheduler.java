package api.scheduler;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;

public class TaskScheduler extends ThreadPoolTaskScheduler {
    private final List<ScheduledFuture<?>> scheduledTasks = new ArrayList<>();

    @Override
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable task, long period) {
        ScheduledFuture<?> future = super.scheduleAtFixedRate(task, period);
        scheduledTasks.add(future);

        return future;
    }

    public void stopTasks() {
        for (ScheduledFuture<?> task: scheduledTasks) {
            task.cancel(false);
        }
    }
}
