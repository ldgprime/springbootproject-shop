package com.cos.shop.model.review.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqSaveDto {
	
	private int id;
	private String title;
	private String content;
	private int userId;
	private int productId;

}