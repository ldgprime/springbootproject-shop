package com.cos.shop.model.bill;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bill {
	private int id;
	private int subCount;
	private int subPrice;
	private int userId;
	private int productId;
	private int paymentId;
	private Date createDate;
	
	@Builder
	public Bill(int subCount, int subPrice, int userId, int productId, int paymentId) {
		
		this.subCount = subCount;
		this.subPrice = subPrice;
		this.userId = userId;
		this.productId = productId;
		this.paymentId = paymentId;
	}
	
	
	
	
}
