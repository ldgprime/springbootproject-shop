package com.cos.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.review.Review;
import com.cos.shop.model.review.dto.ReqSaveDto;

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
	
	
	@GetMapping("/review/api/getreview")
	public ResponseEntity<?> getReview(){
		
		List<RespReviewDto> reviews = rservice.findAll();
		
		
		return new ResponseEntity<List<RespReviewDto>> (reviews, HttpStatus.OK);
	}
	
}