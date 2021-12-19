# Spring boot Currency Conversion Microservices Example

The project demonstrates the end-to-end implementation of the microservices. It has an API Gateway for routing with global filter, Naming Server for Load Balancing and Service Discovery, Configuration Server for centralized Git-based configuration, Microservices, it's call chaining, Circuit Breaker concept implementation. It uses Spring boot version 2.6.1 and Spring cloud version 2021.0.0, and Java 16. The project structure is a Spring boot multimodule project. It helps to define shared maven dependencies in the root (parent) `pom.xml`.

## Root (Parent) pom.xml

```
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.6.1</version> <!-- lookup parent from repository -->
		<relativePath />
	</parent>

	<groupId>com.manoj.ccm</groupId>
	<artifactId>CurrencyConverterMicroservice</artifactId>
	<version>1.0.0</version>
	<packaging>pom</packaging>
	<name>CurrencyConverterMicroservice</name>
	<description>Currency Converter Microservice Application</description>

	<properties>
		<java.version>16</java.version>
		<spring-cloud.version>2021.0.0</spring-cloud.version>
		<lombok.version>1.18.22</lombok.version>
		<archetype.version>3.2.0</archetype.version>
	</properties>

	<modules>
		<module>LimitService</module>
		<module>ConfigService</module>
		<module>CurrencyExchangeService</module>
		<module>CurrencyConversionService</module>
		<module>NamingServer</module>
		<module>APIGateway</module>
	</modules>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
			<exclusions>
				<exclusion>
					<groupId>org.springframework.boot</groupId>
					<artifactId>spring-boot-starter-logging</artifactId>
				</exclusion>
			</exclusions>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-log4j2</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-configuration-processor</artifactId>
			<optional>true</optional>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-actuator</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-devtools</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
		</dependency>
	</dependencies>

	<dependencyManagement>
		<dependencies>
			<dependency>
				<groupId>org.springframework.cloud</groupId>
				<artifactId>spring-cloud-dependencies</artifactId>
				<version>${spring-cloud.version}</version>
				<type>pom</type>
				<scope>import</scope>
			</dependency>
		</dependencies>
	</dependencyManagement>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
			<plugin>
				<groupId>org.apache.maven.plugins</groupId>
				<artifactId>maven-archetype-plugin</artifactId>
				<version>${archetype.version}</version>
				<configuration>
					<propertyFile>archetype.yml</propertyFile>
					<encoding>UTF-8</encoding>
					<filterProperties>java,xml,yaml,yml,properties</filterProperties>
				</configuration>
			</plugin>
		</plugins>
	</build>

</project>
```

## Modules

The project has five modules as list below and each has its own responsibility. 
- API Gateway 
- Configuration Server
- Naming Server
- Microservice-1: Currency Exchange Service
- Microservice-2: Currency Conversion Service
- Microservice-3: Limit Service
 		