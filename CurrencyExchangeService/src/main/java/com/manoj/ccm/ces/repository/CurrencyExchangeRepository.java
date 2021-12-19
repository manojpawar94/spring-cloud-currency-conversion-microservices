package com.manoj.ccm.ces.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manoj.ccm.ces.model.CurrencyExchangeEntity;

@Repository
public interface CurrencyExchangeRepository extends CrudRepository<CurrencyExchangeEntity, String> {

	/**
	 * 
	 * @param currencyFrom
	 * @param currencyTo
	 * @return
	 */
	CurrencyExchangeEntity findByCurrencyFromAndCurrencyTo(String currencyFrom, String currencyTo);
}
