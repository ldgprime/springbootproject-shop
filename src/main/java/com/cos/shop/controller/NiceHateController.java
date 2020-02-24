package com.cos.shop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.nice.dto.ReqNiceDto;
import com.cos.shop.model.product.dto.RespNiceCount;
import com.cos.shop.service.NiceService;

@RestController
public class NiceHateController {
	
	
	@Autowired
	private NiceService nservice;
	
	@PostMapping("/nicehate/api/nice")
	public ResponseEntity<?> nice(@RequestBody ReqNiceDto dto){
		
		RespNiceCount respNiceCount = nservice.nice(dto);
		respNiceCount.setRespCM(new RespCM(200,"ok"));
		
		
		return new ResponseEntity<RespNiceCount>(respNiceCount, HttpStatus.OK);
	}
	

}