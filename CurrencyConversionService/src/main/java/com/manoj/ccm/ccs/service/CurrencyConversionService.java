package com.manoj.ccm.ccs.service;

import java.math.BigDecimal;

import com.manoj.ccm.ccs.bean.CurrencyConversion;

public interface CurrencyConversionService {

	CurrencyConversion calculateCurrencyConversion(String currencyFrom, String currencyTo, BigDecimal quantity);
}
