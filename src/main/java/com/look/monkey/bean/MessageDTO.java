package com.look.monkey.bean;


import lombok.Data;

@Data
public class MessageDTO{
	
	private String shortName;
	private Long programmeSales;
	private Long programmeOtherSales;
	private Integer audienceCount;
	
}