# API Gateway
The API Gateway uses using the `spring-cloud-start-gateway` dependency. It demonstrates the dynamic routing configuration and global filter implementation feature. Also, it connects with the Configuration Server using the `spring-cloud-starter-config` dependency and registers to the service registry using the `spring-cloud-starter-netflix-eureka` dependency.

## application.properties
```
spring.application.name=api-gateway
server.port=8765
spring.config.import=optional:configserver:http://localhost:8888
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka
#spring.cloud.gateway.discovery.locator.enabled=true
#spring.cloud.gateway.discovery.locator.lower-case-service-id=true
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

	<artifactId>APIGateway</artifactId>
	<name>APIGateway</name>
	<description>Application Programming Interface Gateway</description>

	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-config</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-gateway</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
	</dependencies>

</project>
```