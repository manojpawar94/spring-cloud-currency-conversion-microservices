# Currency Conversion Microservice
It is responsible for actual currency conversion functionality. For currency conversion, it takes the help of a currency exchange microservice to get currency exchange information. It calls y exchange microservice using three approaches. The first approach is using the RestTemplate it retrieves currency exchange objects. The second approach is using feign client proxy interface definition. It uses `spring-cloud-starter-openfeign` dependency. And the third approach is using the feign and eureka client with load balancing feature. It uses `spring-cloud-starter-openfeign` and `spring-cloud-starter-netflix-eureka-client` dependency. Also, it registers to the service registry using the `spring-cloud-starter-netflix-eureka` dependency.

## application.properties
```
spring.application.name=currency-conversion
server.port=8100
spring.config.import=optional:configserver:http://localhost:8888
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
spring.main.allow-bean-definition-overriding=true
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

	<artifactId>CurrencyConversionService</artifactId>
	<name>CurrencyConversionService</name>
	<description>Currency Conversion Microservice</description>

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
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>

	</dependencies>

</project>
```