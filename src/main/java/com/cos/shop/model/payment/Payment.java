package com.cos.shop.model.payment;

import java.sql.Date;
import java.sql.Timestamp;

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
	private int userId;
	private Date createDate;
}
