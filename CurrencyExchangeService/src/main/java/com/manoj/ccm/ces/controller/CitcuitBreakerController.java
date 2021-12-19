package com.manoj.ccm.ces.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class CitcuitBreakerController {

	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "sampleDummyFallbackResponse")
	public String sampleDummyApi() {
		log.info("Inside sampleDummyApi");
		String value = new RestTemplate().getForObject("http://localhost:8080/sample-api", String.class);
		log.info("Value -> {}", value);
		return value;
	}

	@GetMapping("/sample-api-circuit-breaker")
	@CircuitBreaker(name = "default", fallbackMethod = "sampleDummyFallbackResponse")
	public String sampleDummyCircuitBreakerApi() {
		log.info("Inside sampleDummyCircuitBreakerApi");
		String value = new RestTemplate().getForObject("http://localhost:8080/sample-api", String.class);
		log.info("Value -> {}", value);
		return value;
	}

	@GetMapping("/sample-api-rate-limiter")
	@RateLimiter(name = "default", fallbackMethod = "sampleDummyFallbackResponse")
	public String sampleDummyRateLimiterApi() {
		log.info("Inside sampleDummyRateLimiterApi");
		return "Rate Limiter Sample Dummy Api Response";
	}

	@GetMapping("/sample-api-bulk-head")
	@Bulkhead(name = "default", fallbackMethod = "sampleDummyFallbackResponse")
	public String sampleBulkHeadApi() throws InterruptedException {
		log.info("Inside sampleBulkHeadApi");
		Thread.sleep(10000);
		return "Bulkhead Sample Dummy Api Response";
	}

	public String sampleDummyFallbackResponse(Exception ex) {
		log.info("Inside Fallback Method of sampleDummyApi");
		return "Dummy Api Response fallback response " + ex.getMessage();
	}
}
