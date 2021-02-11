package com.ggomjae.com.modulebatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling       // 스케줄러 기능을 사용할수 있게 활성화
@EnableBatchProcessing  // 배치기능 활성화
@SpringBootApplication
@EntityScan(basePackages = {"com.ggomjae.com.db"})
@EnableJpaRepositories(basePackages = {"com.ggomjae.com.db"})
public class ModuleBatchApplication {

    public static void main(String[] args) {
        System.out.println("-------------batch-----------------");
        SpringApplication.run(ModuleBatchApplication.class, args);
    }

}
