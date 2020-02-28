package com.cos.shop.model.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqWriteDto {
	
	private String title;
	private String content;
	private int userId;
	private int productId;	

}
