# Configuration Server
The Configuration Server uses using the `spring-cloud-config-server` dependency. It manages the configuration based upon the profile in the central git repository.  The configuration files are present in the `local-config` folder at the root of the project repository. Also, it registers to the service registry using the `spring-cloud-starter-netflix-eureka` dependency.

## application.properties
```
spring.application.name=spring-cloud-config-server
server.port=8888
eureka.client.serviceUrl.defaultZone=http://localhost:8761/eureka

# Spring Cloud Config Server Git Configurations 
# https://cloud.spring.io/spring-cloud-config/multi/multi__spring_cloud_config_server.html#_placeholders_in_git_search_paths
spring.cloud.config.server.git.uri=file:///Users/manojpawar/eclipse-workspace/CurrencyConverterMicroservice
spring.cloud.config.server.git.search-paths=local-config
spring.cloud.config.server.git.default-label=master
spring.cloud.config.server.git.clone-on-start=true
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

	<artifactId>ConfigServer</artifactId>
	<name>ConfigServer</name>
	<description>Config Server Microservice</description>

	<dependencies>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-config-server</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
	</dependencies>

</project>
```