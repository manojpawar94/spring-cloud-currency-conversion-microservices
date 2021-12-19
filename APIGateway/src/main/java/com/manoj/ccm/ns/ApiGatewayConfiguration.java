package com.manoj.ccm.ns;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator getewayRouter(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(p -> p.path("/get")
						.filters(f -> f.addRequestHeader("MyCustomHeader", "MyCustomHeaderURi")
								.addRequestParameter("MyCustomParam", "MyCustomParam"))
						.uri("http://httpbin.org:80"))
				.route(p -> p.path("/currency-exchange/**").uri("lb://currency-exchange-service"))
				.route(p -> p.path("/currency-conversion/**").uri("lb://currency-conversion")).build();
	}
}
