package com.cos.shop.repository;


import java.util.List;

import com.cos.shop.model.review.dto.ReqSaveDto;

import com.cos.shop.model.review.dto.RespReviewDto;

public interface ReviewRepository {
	
	public int save(ReqSaveDto dto);
	
	public RespReviewDto findById(int reviewId);  

	public List<RespReviewDto> findAll();
}
