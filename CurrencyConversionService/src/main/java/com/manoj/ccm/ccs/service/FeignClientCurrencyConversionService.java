package com.manoj.ccm.ccs.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.manoj.ccm.ccs.bean.CurrencyConversion;
import com.manoj.ccm.ccs.proxy.CurrencyExchangeProxy;

@Qualifier("feignClientCurrencyConversionService")
@Service
public class FeignClientCurrencyConversionService implements CurrencyConversionService {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@Override
	public CurrencyConversion calculateCurrencyConversion(String currencyFrom, String currencyTo, BigDecimal quantity) {
		var currencyExchange = currencyExchangeProxy.retrieveCurrencyExchange(currencyFrom, currencyTo);
		return CurrencyConversion.builder().from(currencyFrom).to(currencyTo)
				.totalCalculatedAmount(currencyExchange.getConversionMultiple().multiply(quantity))
				.conversionMultiple(currencyExchange.getConversionMultiple()).quantity(quantity)
				.environment(
						currencyExchange.getEnvironment() + "(feign)::" + environment.getProperty("local.server.port"))
				.build();
	}

}
