package api.configuration;

import api.scheduler.TaskScheduler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class TaskSchedulerConfiguration {

    @Bean
    public TaskScheduler poolScheduler() {
        return new TaskScheduler();
    }

}
