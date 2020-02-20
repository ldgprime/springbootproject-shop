package com.cos.shop.model.comment;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
	private int id;
	private String title;
	private String content;
	private int boardId;
	private int userId;
	private int productId;
	private Date createDate;
	
	@Builder
	public Comment(String title, String content, int boardId, int userId, int productId) {
		super();
		this.title = title;
		this.content = content;
		this.boardId = boardId;
		this.userId = userId;
		this.productId = productId;
	}
	
	
	
	
	
}
