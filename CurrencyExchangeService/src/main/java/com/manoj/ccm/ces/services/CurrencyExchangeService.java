package com.manoj.ccm.ces.services;

import com.manoj.ccm.ces.bean.CurrencyExchange;

public interface CurrencyExchangeService {

	CurrencyExchange getCurrencyExchange(String currencyfrom, String currencyTo);
}
