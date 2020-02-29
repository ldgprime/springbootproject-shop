package com.cos.shop.repository;

import org.apache.ibatis.annotations.Param;

import com.cos.shop.model.hate.dto.ReqHateDto;

public interface HateRepository {

	public int hate(ReqHateDto dto);
	
	public int hateMinus(ReqHateDto dto);
	
	public int findByUserIdProductId(@Param ("userId")int userId, @Param ("productId")int productId);
}
