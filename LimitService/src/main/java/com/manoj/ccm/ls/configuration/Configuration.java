package com.manoj.ccm.ls.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("limit-service")
public class Configuration {
	private int minimum;
	private int maximum;
}
