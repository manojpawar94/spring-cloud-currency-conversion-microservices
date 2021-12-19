package com.manoj.ccm.ces.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.manoj.ccm.ces.bean.CurrencyExchange;
import com.manoj.ccm.ces.repository.CurrencyExchangeRepository;

@Service
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

	@Autowired
	private Environment environment;

	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;

	@Override
	public CurrencyExchange getCurrencyExchange(String currencyfrom, String currencyTo) {
		var currencyExchangeEntity = currencyExchangeRepository.findByCurrencyFromAndCurrencyTo(currencyfrom,
				currencyTo);
		return CurrencyExchange.builder().id(currencyExchangeEntity.getId())
				.from(currencyExchangeEntity.getCurrencyFrom()).to(currencyExchangeEntity.getCurrencyTo())
				.conversionMultiple(currencyExchangeEntity.getConversionMultiple())
				.environment(environment.getProperty("local.server.port")).build();
	}

}
