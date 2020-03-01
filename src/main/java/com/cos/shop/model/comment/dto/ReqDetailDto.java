package com.cos.shop.model.comment.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqDetailDto {
	private int id; // key 값 반환을 위해
	private int userId;
	private int boardId;
	private int productId;
	private String content;
}
