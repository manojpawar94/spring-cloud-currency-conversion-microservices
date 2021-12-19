package com.manoj.ccm.ces.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.ccm.ces.bean.CurrencyExchange;
import com.manoj.ccm.ces.services.CurrencyExchangeService;

@RestController
@RequestMapping("/currency-exchange")
public class CurrencyExchangeController {

	@Autowired
	private CurrencyExchangeService currencyExchangeService;

	@GetMapping("/from/{from}/to/{to}")
	public CurrencyExchange retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to) {
		return currencyExchangeService.getCurrencyExchange(from, to);
	}
}
