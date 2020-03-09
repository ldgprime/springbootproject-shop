package com.cos.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.review.Review;
import com.cos.shop.model.review.dto.ReqReviewPage;
import com.cos.shop.model.review.dto.ReqSaveDto;
import com.cos.shop.model.review.dto.RespReviewContentDto;
import com.cos.shop.model.review.dto.RespReviewDto;
import com.cos.shop.service.ReviewService;

@RestController
public class ReviewController {

	@Autowired
	private ReviewService rservice;
	
	@PostMapping("/review/api/save")
	public ResponseEntity<?> save(@RequestBody ReqSaveDto dto){
		
		RespReviewDto review  = rservice.save(dto);
		review.setRespCM(new RespCM(200,"ok"));		
		
		return new ResponseEntity<RespReviewDto> (review,HttpStatus.OK);
	}
	
	
	@GetMapping("/review/api/getcontent/{reviewId}")
	public ResponseEntity<?> getContent(@PathVariable int reviewId){
		
		RespReviewContentDto content = rservice.findContentById(reviewId);
		content.setRespCM(new RespCM(200,"ok"));		
		
		return new ResponseEntity<RespReviewContentDto> (content,HttpStatus.OK);
	}
	
	
	
	@GetMapping("/review/api/getreview/{productId}/{page}")
	public ResponseEntity<?> getReview(@PathVariable int productId, @PathVariable int page){
		
		System.out.println(page);
		ReqReviewPage reqReviewPage = new ReqReviewPage(productId,page);
		
		List<RespReviewDto> reviews = rservice.findAll(reqReviewPage);
		
		System.out.println(reviews.size());
		return new ResponseEntity<List<RespReviewDto>> (reviews, HttpStatus.OK);
	}
	
}