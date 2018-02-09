package api.configuration;

import api.scheduler.TaskScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;

@Configuration
@EnableScheduling
public class TaskSchedulerConfiguration {
//
//    @Bean
//    public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
//        ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
//        threadPoolTaskScheduler.setPoolSize(10);
//        threadPoolTaskScheduler.setThreadNamePrefix("TaskScheduler");
//        return threadPoolTaskScheduler;
//    }

    @Bean
    public TaskScheduler poolScheduler() {
        return new TaskScheduler();
    }
}
