package com.cos.shop.model.payment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PaymentDto {
	
	private int id;
	private int totalCount;
	private int totalPrice;
	private int userId;
	
}
