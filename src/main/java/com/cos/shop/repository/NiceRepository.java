package com.cos.shop.repository;

import org.apache.ibatis.annotations.Param;

import com.cos.shop.model.nice.dto.ReqNiceDto;


public interface NiceRepository {
	
	public int nice(ReqNiceDto dto);
	
	public int niceMinus(ReqNiceDto dto);
	
	public int findByUserIdProductId(@Param ("userId")int userId, @Param ("productId")int productId);
}
