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
4.SchedulerFactoryBean - SchedulerFactoryBean은 Bean으로 선언하여 다른 클래스에서 DI (dependency injection)해서 사용

```

[QuartzJobLauncher.java]
```
QuartzJobBean을 extends 하게 되면 executeInternal 메서드를 오버라이드 하게 되어있습니다
스케쥴러에 의해 Job 클래스가 호출되었을 때 해당 메서드가 실행되는 거죠. 
```
<div>
    <img align="left" width="100%" src = "https://user-images.githubusercontent.com/43604493/109511989-fbc52480-7ae6-11eb-93fe-e1ec3718031b.PNG">
</div>

```aidl
 quartz + batch 결과
```
<div>
    <img align="left" width="100%" src = "https://user-images.githubusercontent.com/43604493/109510746-b7855480-7ae5-11eb-9cc5-bcdada66557a.PNG">
</div>

