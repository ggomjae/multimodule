package com.ggomjae.com.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/*
    @EntityScan : Entity가 있는 곳 경로
    @EnableJpaRepositories : Repository가 있는 곳 경로

    내 블로그 참고
    https://blog.naver.com/ggomjae/222249705581
 */


@SpringBootApplication
@EntityScan(basePackages = {"com.ggomjae.com.db"})
@EnableJpaRepositories(basePackages = {"com.ggomjae.com.db"})
public class StatisticsApplication {

    public static void main(String[] args) {
        System.out.println("-------------Statistics----------------");
        SpringApplication.run(StatisticsApplication.class, args);
    }
}
