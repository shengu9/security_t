# Spring Security2 
# Spring Security2 List
<details>
<summary> Spring Security2 List 접기/펼치기</summary>

````
1. 프로젝트 생성
2. Gradle 설정
3. application.yml 설정
4. 프로젝트 실행
5. Entity 생성

````

</details>

## 1. 프로젝트 생성
<details>
<summary> 1. 프로젝트 생성 List 접기/펼치기</summary>

![img_1.png](img_1.png)

</details>

## 2. Gradle 설정
<details>
<summary> Gradle 설정 접기/펼치기</summary>

````
plugins {
	id 'java'
	id 'org.springframework.boot' version '2.7.14'
	id 'io.spring.dependency-management' version '1.0.15.RELEASE'
}

group = 'org.spring'
version = '0.0.1-SNAPSHOT'

java {
	sourceCompatibility = '11'
}

configurations {
	compileOnly {
		extendsFrom annotationProcessor
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
	implementation 'org.springframework.boot:spring-boot-starter-security'
	implementation 'org.springframework.boot:spring-boot-starter-validation'
	implementation 'org.springframework.boot:spring-boot-starter-web'
	compileOnly 'org.projectlombok:lombok'
	developmentOnly 'org.springframework.boot:spring-boot-devtools'
	runtimeOnly 'com.mysql:mysql-connector-j'
	annotationProcessor 'org.springframework.boot:spring-boot-configuration-processor'
	annotationProcessor 'org.projectlombok:lombok'
	testImplementation 'org.springframework.boot:spring-boot-starter-test'
	testImplementation 'org.springframework.security:spring-security-test'
	// https://mvnrepository.com/artifact/nz.net.ultraq.thymeleaf/thymeleaf-layout-dialect
	implementation group: 'nz.net.ultraq.thymeleaf', name: 'thymeleaf-layout-dialect'
// https://mvnrepository.com/artifact/org.thymeleaf.extras/thymeleaf-extras-springsecurity5
	implementation group: 'org.thymeleaf.extras', name: 'thymeleaf-extras-springsecurity5'
}

tasks.named('test') {
	useJUnitPlatform()
}

````

</details>

## 3. application.yml 설정
<details>
<summary> 3. application.yml 설정 접기/펼치기</summary>

````
server:
  port: 포토번호

spring:
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/DB명
    username: 사용자
    password: 비빌번호

  jpa:
    database-platform: org.hibernate.dialect.MySQL8Dialect
    hibernate:
      ddl-auto: create
    properties:
      hibernate:
        show_sql: true
        format_sql: true


  thymeleaf:
    cache: false
    check-template-location: true
    #    prefix: classpath:/templates/
    #    suffix: .html
    enabled: true


````

</details>


## 4. 프로젝트 실행
<details>
<summary> 4. 프로젝트 실행 설정 접기/펼치기</summary>

````
시큐리티 비빌번호 생성 
Using generated security password: a3ba2d13-cf66-4bb0-a5e6-52639c88d509

![img_2.png](img_2.png)

http://localhost:8095/login    -> 기본적인 모든 요청정보 
http://localhost:8095/logout     -> 기본적인 로그아웃 ULR   /logout

![img_3.png](img_3.png)

````

</details>


## 5. Entity 생성
### 5-1 BaseEntity 생성 및 설정
<details>
<summary>  5-1 BaseEntity 생성 및 설정 접기/펼치기</summary>

![img_4.png](img_4.png)

![img_5.png](img_5.png)

![img_6.png](img_6.png)

</details>











# security_t
