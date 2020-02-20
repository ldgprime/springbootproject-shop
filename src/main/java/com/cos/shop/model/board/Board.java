package com.cos.shop.model.board;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private int id;
	private String title;
	private String content;
	private int userId;
	private int productId;
	private Date createDate;
	
	@Builder
	public Board(String title, String content, int userId, int productId) {
		super();
		this.title = title;
		this.content = content;
		this.userId = userId;
		this.productId = productId;
	}
	
	
	
	
}
