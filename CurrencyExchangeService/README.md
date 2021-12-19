# Currency Exchange Microservice
It is responsible for the Currency Exchange related information. It connects to the in-memory h2 database using JPA to maintain the currency exchange information. It demonstrates fault tolerance and circuit breaker functionality `resilience4j-spring-boot2` and it's peer dependency `spring-boot-starter-aop`. Also, it registers to the service registry using the spring-cloud-starter-netflix-eureka dependency.
 
## application.properties
```
server.port=8000
spring.application.name=currency-exchange-service
spring.config.import=optional:configserver:http://localhost:8888
spring.jpa.show-sql=true
spring.jpa.defer-datasource-initialization=true
spring.datasource.url= jdbc:h2:mem:crrExgDb
spring.h2.console.enabled=true
spring.h2.console.path=/h2
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
resilience4j.retry.instances.sample-api.max-attempts=5
resilience4j.retry.instances.sample-api.wait-duration=1s
resilience4j.retry.instances.sample-api.enable-exponential-backoff=true
resilience4j.ratelimiter.instances.default.limit-for-period=2
resilience4j.ratelimiter.instances.default.limit-refresh-period=10s
resilience4j.bulkhead.instances.default.max-concurrent-calls=2
```

## pom.xml
```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<parent>
		<groupId>com.manoj.ccm</groupId>
		<artifactId>CurrencyConverterMicroservice</artifactId>
		<version>1.0.0</version>
	</parent>

	<artifactId>CurrencyExchangeService</artifactId>
	<name>CurrencyExchangeService</name>
	<description>Currency Exchange Microservice</description>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-aop</artifactId>
		</dependency>

		<dependency>
			<groupId>io.github.resilience4j</groupId>
			<artifactId>resilience4j-spring-boot2</artifactId>
		</dependency>

	</dependencies>

</project>
```