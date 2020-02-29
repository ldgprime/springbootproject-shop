package com.cos.shop.repository;

import java.util.List;


import com.cos.shop.model.bill.dto.BillDto;
import com.cos.shop.model.bill.dto.FindAllUserIdBillDto;

public interface BillRepository {
	
	
	public List<FindAllUserIdBillDto> findAllUserIdBill(int userId);	
	
	public void bill(BillDto billDto);

}

