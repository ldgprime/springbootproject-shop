package com.cos.shop.model.review;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Review {
	private int id;
	private String title;
	private String content;
	private int userId;
	private int productId;
	private Date createDate;
	
	
	@Builder
	public Review(String title, String content, int userId, int productId) {

		this.title = title;
		this.content = content;
		this.userId = userId;
		this.productId = productId;
	}
	
	
	
}
