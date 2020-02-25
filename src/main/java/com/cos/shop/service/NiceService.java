package com.cos.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.shop.model.nice.dto.ReqNiceDto;
import com.cos.shop.model.nice.dto.RespNiceProductIdDto;
import com.cos.shop.model.product.dto.RespNiceCount;
import com.cos.shop.repository.NiceRepository;
import com.cos.shop.repository.ProductRepository;

@Service
public class NiceService {

	@Autowired
	private NiceRepository nRepository;
	
	@Autowired
	private ProductRepository pRepository;	
	
	
	public RespNiceCount nice(ReqNiceDto dto) {

		int result1 = nRepository.nice(dto);		
		
		if(result1 == 1) {
			int result2 = pRepository.updateNiceCount(dto.getProductId());
			if(result2 == 1) {
				RespNiceCount respNiceCount = pRepository.findByIdNiceCount(dto);
				return respNiceCount;
			}
			
		}
		return null;		
	}
	
	public RespNiceCount niceMinus(ReqNiceDto dto) {

		int result1 = nRepository.niceMinus(dto);		
		
		if(result1 == 1) {
			int result2 = pRepository.updateNiceMinusCount(dto.getProductId());
			if(result2 == 1) {
				RespNiceCount respNiceCount = pRepository.findByIdNiceCount(dto);
				return respNiceCount;
			}
			
		}
		return null;		
	}
	
	public int findByUserIdProductId(int userId, int productId) {		
		
		int result = nRepository.findByUserIdProductId(userId,productId);
		
		return result;
		
	}


}