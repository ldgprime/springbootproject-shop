package com.cos.shop.model.hate;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hate {
	private int id;
	private int userId;
	private int producId;
	private Date createDate;
	
	@Builder
	public Hate(int userId, int producId) {

		this.userId = userId;
		this.producId = producId;
	}
	
	

}
