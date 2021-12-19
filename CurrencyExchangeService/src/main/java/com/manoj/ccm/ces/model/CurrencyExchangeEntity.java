package com.manoj.ccm.ces.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Entity(name = "currency_exchange")
public class CurrencyExchangeEntity {
	@Id
	private long id;
	private String currencyFrom;
	private String currencyTo;
	private BigDecimal conversionMultiple;
}
