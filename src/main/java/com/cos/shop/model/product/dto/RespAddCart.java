package com.cos.shop.model.product.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespAddCart {

	private int id;
	private String productName;
	private int productPrice;		
	private String imageOne;
	private String imageTwo;	
	private int niceCount;
	private int hateCount;
	private int Count;	
	private Date createDate;
	
	@Builder
	public RespAddCart(String productName, int productPrice, String imageOne, String imageTwo, int niceCount,
			int hateCount) {
	
		this.productName = productName;
		this.productPrice = productPrice;
		this.imageOne = imageOne;
		this.imageTwo = imageTwo;
		this.niceCount = niceCount;
		this.hateCount = hateCount;
	}
	
	
	
	
	
}
