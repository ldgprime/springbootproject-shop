package com.cos.shop.model.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(force=true)
@AllArgsConstructor
public class Product {
	private int id;
	private String productName;
	private int productPrice;
	private int niceCount;
	private int hateCount;
		
}
