package com.cos.shop.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class ProductController {
	
	@GetMapping({"/","","/index"})
	public String index() {
		return "index";
	}

	@GetMapping("/product/bill")
	public String bill() {
		return "/product/bill";
	}
	@GetMapping("/product/cart")
	public String cart() {		
		return "/product/cart";
	}
	@GetMapping("/product/product")
	public String product() {
		return "/product/product";
	}
	@GetMapping("/product/productdetail")
	public String productDetail() {
		return "/product/productdetail";
	}






}