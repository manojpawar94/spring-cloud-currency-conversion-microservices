# Spring Cloud Eureka Naming Server
It acts as a service registry of microservices as called as `Naming Server`. It uses `spring-cloud-starter-netflix-eureka-server` dependency. Each service registers itself whenever an instance comes up. It helps for auto-scaling up and down verify effectively. Also, It plays an important role in the load balancing in the microservice.

## application.properties
```
spring.application.name=naming-server
server.port=8761

eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false

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

	<artifactId>NamingServer</artifactId>
	<name>NamingServer</name>
	<description>Eureka Naming Server</description>

	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
	</dependencies>

</project>
```