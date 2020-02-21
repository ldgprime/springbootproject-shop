package com.cos.shop.repository;

import com.cos.shop.model.payment.dto.PaymentDto;

public interface PaymentRepository {
	
	public int payment(PaymentDto paymentDto);

}
