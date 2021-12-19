package com.manoj.ccm.ces.bean;

import java.math.BigDecimal;

import lombok.Builder;

@Builder
public record CurrencyExchange(long id, String from, String to, BigDecimal conversionMultiple, String environment) {
}
