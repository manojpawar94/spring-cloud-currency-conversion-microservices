package com.manoj.ccm.ccs.service;

import java.math.BigDecimal;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.manoj.ccm.ccs.bean.CurrencyConversion;
import com.manoj.ccm.ccs.bean.CurrencyExchange;

@Qualifier("currencyConversionServiceImpl")
@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	@Autowired
	private Environment environment;

	@Override
	public CurrencyConversion calculateCurrencyConversion(String currencyFrom, String currencyTo, BigDecimal quantity) {
		var uriVariableMap = new HashMap<String, String>();
		uriVariableMap.put("from", currencyFrom);
		uriVariableMap.put("to", currencyTo);
		var currencyExchange = new RestTemplate().getForObject(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyExchange.class, uriVariableMap);
		return CurrencyConversion.builder().from(currencyFrom).to(currencyTo)
				.totalCalculatedAmount(currencyExchange.getConversionMultiple().multiply(quantity))
				.conversionMultiple(currencyExchange.getConversionMultiple()).quantity(quantity)
				.environment(currencyExchange.getEnvironment() + "->" + environment.getProperty("local.server.port"))
				.build();
	}

}
