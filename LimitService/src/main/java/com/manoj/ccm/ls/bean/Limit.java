package com.manoj.ccm.ls.bean;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Limit {
	private int minimum;
	private int maximun;
}
