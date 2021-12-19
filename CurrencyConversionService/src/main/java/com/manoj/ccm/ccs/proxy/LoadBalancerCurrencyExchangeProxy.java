package com.manoj.ccm.ccs.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.manoj.ccm.ccs.bean.CurrencyExchange;

@FeignClient(name = "currency-exchange-service")
public interface LoadBalancerCurrencyExchangeProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveCurrencyExchange(@PathVariable String from, @PathVariable String to);

}
