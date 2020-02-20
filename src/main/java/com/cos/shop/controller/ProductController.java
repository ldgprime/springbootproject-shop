package com.cos.shop.controller;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.product.Product;
import com.cos.shop.model.product.dto.RespAddCart;
import com.cos.shop.service.ProductService;

@Controller 
public class ProductController {
	
	
	@Autowired
	private ProductService pservice;
	
	@GetMapping({"/","","/index"})
	public String index() {
		return "index";
	}

	@GetMapping("/product/bill")
	public String bill() {
		return "/product/bill";
	}
	@GetMapping("/product/cart")
	public String cart(HttpServletRequest req, HttpServletResponse resp, Model model) {		
		
		Cookie[] cookies = req.getCookies();
		List<RespAddCart> respAddCarts = new ArrayList<RespAddCart>();
		
		for(int i = 0; i<cookies.length; i++ ) {
			
			System.out.println("Name = " + cookies[i].getName());
			System.out.println("value = " + cookies[i].getValue());
			List<Product> searchProducts =  pservice.findAll();
			
			for(int j = 0; j<searchProducts.size(); j++) {
				if(cookies[i].getName().equals(searchProducts.get(j).getId()+"")) {
					RespAddCart respAddCart = pservice.findByIdAddCart(searchProducts.get(j).getId());
					respAddCart.setCount(Integer.parseInt(cookies[i].getValue()));
					System.out.println(respAddCart.getImageOne());
					respAddCarts.add(respAddCart);
				}
				
			}	
			
		}
		
		model.addAttribute("respAddCarts", respAddCarts);		
		
		
		return "/product/cart";
	}
	
	@GetMapping("/product/product")
	public String product(Model model) {
		
		List<Product> products = pservice.findAll();
		
		model.addAttribute("products", products);		
		
		return "/product/product";
		
	}
	
	@GetMapping("/product/productdetail/{productId}")
	public String productDetail(@PathVariable int productId, Model model) {
		
		Product product = pservice.findById(productId);
		
		model.addAttribute("product", product);
		
		
		return "/product/productdetail";
	}
	
	@GetMapping("/product/productdetail//api/{productId}/{productCount}")
	public ResponseEntity<?> addCart(@PathVariable int productId, @PathVariable int productCount, HttpServletResponse resp ){
		
		System.out.println(productId);
		System.out.println(productCount);
		
		Cookie cookie = new Cookie(productId+"",productCount+"");
		
		System.out.println(cookie);
		cookie.setMaxAge(60*60*24*7);		
		resp.addCookie(cookie);
		
		
		return new ResponseEntity<RespCM> (new RespCM(200,"ok"),HttpStatus.OK);
	}






}