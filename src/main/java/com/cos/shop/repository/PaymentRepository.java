package com.cos.shop.repository;

import java.util.List;

import com.cos.shop.model.payment.Payment;
import com.cos.shop.model.payment.dto.PaymentDto;

public interface PaymentRepository {
	
	public int payment(PaymentDto paymentDto);
	
	public List<Payment> FindAllUserIdPayment(int userId);

}
