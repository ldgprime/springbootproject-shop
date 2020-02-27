package com.cos.shop.repository;

import java.util.List;

import com.cos.shop.model.hate.dto.ReqHateDto;
import com.cos.shop.model.nice.dto.ReqNiceDto;
import com.cos.shop.model.product.Product;
import com.cos.shop.model.product.dto.RespAddCart;
import com.cos.shop.model.product.dto.RespHateCount;
import com.cos.shop.model.product.dto.RespNiceCount;

public interface ProductRepository {
	
	public List<Product> findAll();
	
	public Product findById(int productId);
	
	public RespAddCart findByIdAddCart(int productId);
	
	public int updateNiceCount(int productId);
	
	public int updateNiceMinusCount(int productId);
	
	public int updateHateCount(int productId);
	
	public int updateHateMinusCount(int productId);
	
	public RespNiceCount findByIdNiceCount(ReqNiceDto dto);

	public RespHateCount findByIdHateCount(ReqHateDto dto);
	
	public List<Product> findByKeyword(String keyword);
	

}

