package com.manoj.ccm.ccs.bean;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class CurrencyExchange {
	private long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private String environment;
}
