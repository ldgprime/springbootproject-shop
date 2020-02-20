package com.cos.shop.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.shop.model.product.Product;
import com.cos.shop.model.product.dto.RespAddCart;
import com.cos.shop.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pRepository;
	
	
	
	public List<Product> findAll(){
		
		List<Product> products = pRepository.findAll();
		
		return products;
		
	}
	
	
	public Product findById(int productId){
		
		Product product = pRepository.findById(productId);
		
		return product;
		
	}
	
	
	public RespAddCart findByIdAddCart(int productId){
		
		RespAddCart respAddCart = pRepository.findByIdAddCart(productId);
		
		return respAddCart;
		
	}
	
	



}