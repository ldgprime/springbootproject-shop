package com.cos.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.shop.model.review.Review;
import com.cos.shop.model.review.dto.ReqReviewPage;
import com.cos.shop.model.review.dto.ReqSaveDto;
import com.cos.shop.model.review.dto.RespReviewContentDto;
import com.cos.shop.model.review.dto.RespReviewDto;
import com.cos.shop.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository rrepository;
	
	
	public RespReviewDto save(ReqSaveDto dto) {
		int result = rrepository.save(dto);
		if(result == 1) {
			
			RespReviewDto review = rrepository.findById(dto.getId());
			
			return review;
		}	
		return null;
		
	}
	
	public RespReviewContentDto findContentById(int reviewId) {
		RespReviewContentDto content = rrepository.findContentById(reviewId);
		return content;
	}
	
	public List<RespReviewDto> findAll(ReqReviewPage reqReviewPage) {
		
		
		reqReviewPage.setPage(reqReviewPage.getPage()-1);		
		List<RespReviewDto> reviews = rrepository.findAll(reqReviewPage);
		
		return  reviews;
	}

	public int setTotalCount(int productId) {
		return rrepository.setTotalCount(productId);
	}


}