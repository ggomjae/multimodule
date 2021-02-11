package com.ggomjae.com.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"com.ggomjae.com.db"})
@EnableJpaRepositories(basePackages = {"com.ggomjae.com.db"})
public class StatisticsApplication {

    public static void main(String[] args) {
        System.out.println("-------------Statistics----------------");
        SpringApplication.run(StatisticsApplication.class, args);
    }
}
