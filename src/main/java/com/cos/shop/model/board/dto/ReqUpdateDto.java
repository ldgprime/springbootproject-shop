package com.cos.shop.model.board.dto;

import lombok.NoArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqUpdateDto {
	
	private int id;
	private String title;
	private String content;

}
