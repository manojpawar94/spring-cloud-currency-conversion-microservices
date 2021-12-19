# Limits Microservice 
It demonstrates the functionality of reading the configuration from the Spring Configuration Server using the `spring-cloud-starter-config` dependency. Also, it registers to the service registry using the `spring-cloud-starter-netflix-eureka` dependency.

## application.properties
```
spring.application.name=limits-service
server.port=8080
spring.config.import=optional:configserver:http://localhost:8888

limit-service.minimum=1
limit-service.maximum=1000
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

	<artifactId>LimitService</artifactId>
	<name>LimitService</name>
	<description>Limit Microservice</description>
	<packaging>jar</packaging>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

	</dependencies>

</project>
```