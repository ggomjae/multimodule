package com.ggomjae.com.modulebatch.schedule;

import com.ggomjae.com.modulebatch.jobs.JobConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.JobExecutionException;
import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@RequiredArgsConstructor
@Component
public class ScheduleTask {

    private final JobLauncher jobLauncher;

    private final JobConfig jobConfig;

    @Scheduled(initialDelay = 10000, fixedDelay = 30000)
    public void runJob() {

        Map<String, JobParameter> confMap = new HashMap<>();
        confMap.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters jobParameters = new JobParameters(confMap);

        try {
            jobLauncher.run(jobConfig.postJob(), jobParameters);
        } catch (JobExecutionException e) {
            System.out.println(e.getMessage());
        }
    }
}
