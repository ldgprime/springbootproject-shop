package com.cos.shop.model.bill.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BillDto {

	private int subCount;
	private int subPrice;
	private int userId;
	private int productId;
	private int paymentId;
	
}
