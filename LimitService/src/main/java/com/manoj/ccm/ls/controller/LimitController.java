package com.manoj.ccm.ls.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.manoj.ccm.ls.bean.Limit;
import com.manoj.ccm.ls.configuration.Configuration;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
public class LimitController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public Limit retrieveLimit() {
		log.info("retrieving limit...");
		return Limit.builder().minimum(configuration.getMinimum()).maximun(configuration.getMaximum()).build();
	}
}
