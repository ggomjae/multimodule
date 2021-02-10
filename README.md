multiproject 
 - module-batch  : 배치 모듈 <br>
 - statistics    : api 모듈


이런 방식도 있음. 각 모듈에는 build.gradle이 비어있음.
```aidl
buildscript {
    ext {
        springBootVersion = '2.1.5.RELEASE'
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
        classpath "io.spring.gradle:dependency-management-plugin:0.6.0.RELEASE"
    }
}

subprojects {
    apply plugin: 'java'
    apply plugin: 'eclipse'
    apply plugin: 'org.springframework.boot'
    apply plugin: 'io.spring.dependency-management'

    group = 'com.salt'
    version = '0.0.1-SNAPSHOT'
    sourceCompatibility = 1.8

    repositories {
        mavenCentral()
    }

    dependencies {
        compileOnly('org.projectlombok:lombok')
        compile('org.springframework.boot:spring-boot-starter-jdbc')
        testCompile group: 'junit', name: 'junit', version: '4.12'
        testCompile('org.springframework.boot:spring-boot-starter-test')
        runtime('mysql:mysql-connector-java')
        runtime('com.h2database:h2')
    }
}


project(':module-common') {
    dependencies {
        compile('org.springframework.boot:spring-boot-starter-data-jpa')

    }
}

project(':module-web') {
    dependencies {
        compile project(':module-common')
        compile('org.springframework.boot:spring-boot-starter-web')
    }
}

project(':module-api') {
    dependencies {
        compile project(':module-common')
    }
}

project('module-batch') {
    dependencies {
        compile project(':module-common')
    }
}

```