package com.cos.shop.repository;


import java.util.List;

import com.cos.shop.model.review.dto.ReqReviewPage;
import com.cos.shop.model.review.dto.ReqSaveDto;
import com.cos.shop.model.review.dto.RespReviewContentDto;
import com.cos.shop.model.review.dto.RespReviewDto;

public interface ReviewRepository {
	
	public int save(ReqSaveDto dto);
	
	public RespReviewDto findById(int reviewId);  

	public List<RespReviewDto> findAll(ReqReviewPage reqReviewPage);
	
	public RespReviewContentDto findContentById(int reviewId);
	
	public int setTotalCount(int productId);
}
