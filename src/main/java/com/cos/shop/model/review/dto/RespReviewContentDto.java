package com.cos.shop.model.review.dto;

import com.cos.shop.model.RespCM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespReviewContentDto {
	
	private RespCM respCM;
	private String content;

}
