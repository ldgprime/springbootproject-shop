package com.cos.shop.model.bill.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FindAllUserIdBillDto {
	
	private String imageOne;
	private String productName;
	private int productPrice;
	private int subCount;
	private int subPrice;
	private Date createDate;

}
