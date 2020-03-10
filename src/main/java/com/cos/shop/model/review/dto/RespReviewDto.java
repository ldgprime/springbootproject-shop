package com.cos.shop.model.review.dto;

import java.sql.Date;

import com.cos.shop.model.PageMaker;
import com.cos.shop.model.RespCM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespReviewDto {
	
	private RespCM respCM;
	private PageMaker reviewPageMaker;
	
	private int id;
	private String title;	
	private String username;
	private int productId;
	private Date createDate;
	
	

}
