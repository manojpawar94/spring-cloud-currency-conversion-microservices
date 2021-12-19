package com.manoj.ccm.ccs.bean;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record CurrencyConversion(String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
		BigDecimal totalCalculatedAmount, String environment) {
}
