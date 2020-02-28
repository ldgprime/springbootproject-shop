package com.cos.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.hate.dto.ReqHateDto;
import com.cos.shop.model.hate.dto.RespHateDto;
import com.cos.shop.model.nice.dto.ReqNiceDto;
import com.cos.shop.model.product.dto.RespHateCount;
import com.cos.shop.model.product.dto.RespNiceCount;
import com.cos.shop.service.HateService;
import com.cos.shop.service.NiceService;

@RestController
public class NiceHateController {
	
	
	@Autowired
	private NiceService nservice;
	
	
	@Autowired
	private HateService hservice;
	
	@PostMapping("/nicehate/api/nice")
	public ResponseEntity<?> nice(@RequestBody ReqNiceDto dto){
		System.out.println(dto);
		RespNiceCount respNiceCount = nservice.nice(dto);
		respNiceCount.setRespCM(new RespCM(200,"ok"));
		
		
		return new ResponseEntity<RespNiceCount>(respNiceCount, HttpStatus.OK);
	}
	
	@DeleteMapping("/nicehate/api/niceminus")
	public ResponseEntity<?> niceMinus(@RequestBody ReqNiceDto dto){
	
		RespNiceCount respNiceCount = nservice.niceMinus(dto);
		respNiceCount.setRespCM(new RespCM(200,"ok"));
		
		
		return new ResponseEntity<RespNiceCount>(respNiceCount, HttpStatus.OK);
	}
	
	
	@PostMapping("/nicehate/api/hate")
	public ResponseEntity<?> hate(@RequestBody ReqHateDto dto){
		
		RespHateCount respHateCount = hservice.hate(dto);
		respHateCount.setRespCM(new RespCM(200,"ok"));
		
		
		return new ResponseEntity<RespHateCount>(respHateCount, HttpStatus.OK);
	}
	
	@DeleteMapping("/nicehate/api/hateminus")
	public ResponseEntity<?> hateMinus(@RequestBody ReqHateDto dto){
		
		RespHateCount respHateCount = hservice.hateMinus(dto);
		respHateCount.setRespCM(new RespCM(200,"ok"));
		
		
		return new ResponseEntity<RespHateCount>(respHateCount, HttpStatus.OK);
	}
	
	

}