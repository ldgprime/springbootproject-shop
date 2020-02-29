package com.cos.shop.model.product;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor(force=true)
@AllArgsConstructor
public class Product {
	private int id;
	private String productName;
	private int productPrice;
	//추가
	private String imageOne;
	//추가
	//추가
	private String imageTwo;
	//추가
	private int niceCount;
	private int hateCount;
	//추가
	private Date createDate;
	//추가
	
	@Builder
	public Product(String productName, int productPrice, int niceCount, int hateCount) {
		super();
		this.productName = productName;
		this.productPrice = productPrice;
		this.niceCount = niceCount;
		this.hateCount = hateCount;
	}
	
	
	
	
	
}

