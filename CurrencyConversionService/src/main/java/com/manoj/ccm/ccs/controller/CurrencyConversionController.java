package com.manoj.ccm.ccs.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.ccm.ccs.bean.CurrencyConversion;
import com.manoj.ccm.ccs.service.CurrencyConversionService;

@RestController
@RequestMapping("/currency-conversion")
public class CurrencyConversionController {

	@Qualifier("currencyConversionServiceImpl")
	@Autowired
	private CurrencyConversionService currencyConversionServiceImpl;

	@Qualifier("feignClientCurrencyConversionService")
	@Autowired
	private CurrencyConversionService feignClientCurrencyConversionService;

	@Qualifier("loadBalancerCurrencyConversionService")
	@Autowired
	private CurrencyConversionService loadBalancerCurrencyConversionService;

	@GetMapping("/from/{from}/to/{to}")
	public CurrencyConversion calcualateCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@RequestParam BigDecimal quantity) {
		return currencyConversionServiceImpl.calculateCurrencyConversion(from, to, quantity);
	}

	@GetMapping("/feign/from/{from}/to/{to}")
	public CurrencyConversion calcualateFiegnCurrencyConversion(@PathVariable String from, @PathVariable String to,
			@RequestParam BigDecimal quantity) {
		return feignClientCurrencyConversionService.calculateCurrencyConversion(from, to, quantity);
	}

	@GetMapping("/loadbalancer/from/{from}/to/{to}")
	public CurrencyConversion calcualateLoadBalancerCurrencyConversion(@PathVariable String from,
			@PathVariable String to, @RequestParam BigDecimal quantity) {
		return loadBalancerCurrencyConversionService.calculateCurrencyConversion(from, to, quantity);
	}

}
