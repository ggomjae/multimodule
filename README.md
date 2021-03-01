multiproject 
 - module-batch  : 배치 모듈 + @Scheduled <br>
 - module-batch-quartz  : 배치 모듈 + quartz <br>
 - module-commons : DB관련 모듈 <br> 
 - statistics    : api 모듈

[QuartzConfig.java]
```
JobLauncher : 배치작업을 실행시키는 역할
JobLocator : 탐지,이름별로 작업 구성을 검색하는 런타임 서비스 로케이터 인터페이스.
JobRegistryBeanPostProcessor : Bean post-processor으로 Application Context가 올라가면서 bean 등록 시, 자동으로 JobRegistry에 Job을 등록 시켜준다.
JobRegistry : context에서 Job을 추적하거나 다른 곳에서 생성된 Job을 application context의 중앙에 모을 때 유용하다. 등록된 Job의 이름과 속성들을 조작할 수 있으며 job name과 job instance의 Map의 형태
jobDetailFactoryBean : job을 정의할 jobDetailFactoryBean,jobDetail
연결해 실행주기를 정의할 cronTriggerFactoryBean, 트리거를 스케줄러로 생성해줄 SchedulerFactoryBean

uartzJobLauncher : 파라미터를 기반으로 Spring Batch의 Job을 구동시키는 역할

1.JobRegistryBeanPostProcessor
2.JobDetailFactoryBean - QuartzJobLauncher.class를 setting 함
3.CronTriggerFactoryBean
4.SchedulerFactoryBean

import org.springframework.batch.core.configuration.JobLocator
import org.springframework.batch.core.launch.JobLauncher

JobLocator, JobLauncher를 2번인 JobDetailFactoryBean[QuartzJob] 에서 셋팅을 해줌
@Bean
    public JobDetailFactoryBean jobDetailFactoryBean() {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobClass(QuartzJobLauncher.class);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("jobName", "testJob");
        map.put("jobLauncher", jobLauncher);
        map.put("jobLocator", jobLocator);

        jobDetailFactoryBean.setJobDataAsMap(map);

        return jobDetailFactoryBean;
    }

```

[QuartzJobLauncher.java]
```
QuartzJobBean을 extends 하게 되면 executeInternal 메서드를 오버라이드 하게 되어있습니다
```
<div>
    <img align="left" width="100%" src = "https://user-images.githubusercontent.com/43604493/109496515-180b9600-7ad4-11eb-83d1-b9289362bece.PNG">
</div>

사진 참고 : https://blog.kingbbode.com/38
