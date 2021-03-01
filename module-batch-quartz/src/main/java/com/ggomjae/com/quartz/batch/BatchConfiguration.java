package com.ggomjae.com.quartz.batch;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
@RequiredArgsConstructor
@EnableBatchProcessing
public class BatchConfiguration {

    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final CustomItemReader customItemReader;
    private final CustomItemWriter customItemWriter;
    private final ItemWriter2 itemWriter2;
    private final ItemReader2 itemReader2;

    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1")
                .<Object, Object> chunk(10)
                .reader(customItemReader)
                .writer(customItemWriter)
                .build();
    }

    @Bean
    public Step step2() {
        return stepBuilderFactory.get("step2")
                .<Object, Object> chunk(10)
                .reader(itemReader2)
                .writer(itemWriter2)
                .build();
    }

    @Bean
    public Job testJob() {
        return jobBuilderFactory.get("testJob")
                .incrementer(new RunIdIncrementer())
                .flow(step1())
                .end()
                .build();
    }

    @Bean
    public Job testJob2() {
        return jobBuilderFactory.get("testJob2")
                .incrementer(new RunIdIncrementer())
                .flow(step2())
                .end()
                .build();
    }
}