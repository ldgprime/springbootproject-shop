package com.cos.shop.model.board.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespBoardDto {
	
	private int id;
	private String title;
	private String content;
	private String username;
	private int productId;
	private Date createDate; 
	
}
