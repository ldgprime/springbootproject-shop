package com.cos.shop.model.payment;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	private int id;
	private int totalCount;
	private int totalprice;
	//추가
	private int shipingFee;
	//추가
	private int userId;
	private Date createDate;
}
