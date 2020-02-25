package com.cos.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.shop.model.hate.dto.ReqHateDto;
import com.cos.shop.model.product.dto.RespHateCount;
import com.cos.shop.repository.HateRepository;
import com.cos.shop.repository.ProductRepository;

@Service
public class HateService {

	@Autowired
	private HateRepository hRepository;
	
	@Autowired
	private ProductRepository pRepository;	
	
	public RespHateCount hate(ReqHateDto dto) {
	
		int result1 = hRepository.hate(dto);		
		
		if(result1 == 1) {
			int result2 = pRepository.updateHateCount(dto.getProductId());
			if(result2 == 1) {
				RespHateCount respHateCount = pRepository.findByIdHateCount(dto);
				return respHateCount;
			}
			
		}
		return null;		
	}
	
	public RespHateCount hateMinus(ReqHateDto dto) {
		
		int result1 = hRepository.hateMinus(dto);		
		
		if(result1 == 1) {
			int result2 = pRepository.updateHateMinusCount(dto.getProductId());
			if(result2 == 1) {
				RespHateCount respHateCount = pRepository.findByIdHateCount(dto);
				return respHateCount;
			}
			
		}
		
		return null;		
	}

	public int findByUserIdProductId(int userId, int productId) {		
		
		int result = hRepository.findByUserIdProductId(userId,productId);
		
		return result;
		
	}

}