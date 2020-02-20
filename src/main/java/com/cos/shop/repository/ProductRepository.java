package com.cos.shop.repository;

import java.util.List;

import com.cos.shop.model.product.Product;
import com.cos.shop.model.product.dto.RespAddCart;

public interface ProductRepository {
	
	public List<Product> findAll();
	
	public Product findById(int productId);
	
	public RespAddCart findByIdAddCart(int productId);

}
