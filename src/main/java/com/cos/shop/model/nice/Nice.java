package com.cos.shop.model.nice;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Nice {
	private int id;
	private int userId;
	private int producId;
	private Date createDate;
	
	@Builder
	public Nice(int userId, int producId) {
	
		this.userId = userId;
		this.producId = producId;
	}
	
	
	

}
