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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.bill.dto.FindAllUserIdBillDto;
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
		return "product/bill";
	}
	@GetMapping("/product/cart")
	public String cart(HttpServletRequest req, HttpServletResponse resp, Model model) {		
		
		Cookie[] cookies = req.getCookies();
		List<RespAddCart> respAddCarts = new ArrayList<RespAddCart>();
		
		for(int i = 0; i<cookies.length; i++ ) {
	
			List<Product> searchProducts =  pservice.findAllProduct();
			
			for(int j = 0; j<searchProducts.size(); j++) {
				if(cookies[i].getName().equals(searchProducts.get(j).getId()+"")) {
					RespAddCart respAddCart = pservice.findByIdAddCartProduct(searchProducts.get(j).getId());
					respAddCart.setCount(Integer.parseInt(cookies[i].getValue()));				
					respAddCarts.add(respAddCart);
				}
				
			}	
			
		}
		
		model.addAttribute("respAddCarts", respAddCarts);		
		
		
		return "product/cart";
	}
	
	@GetMapping("/product/product")
	public String product(Model model) {
		
		List<Product> products = pservice.findAllProduct();
		
		model.addAttribute("products", products);		
		
		return "product/product";
		
	}
	
	@GetMapping("/product/productdetail/{productId}")
	public String productDetail(@PathVariable int productId, Model model) {
		
		Product product = pservice.findByIdProduct(productId);
		
		model.addAttribute("product", product);		
		
		return "product/productdetail";
	}
	
	@GetMapping("/product/productdetail//api/{productId}/{productCount}")
	public ResponseEntity<?> addCart(@PathVariable int productId, @PathVariable int productCount, HttpServletResponse resp ){
		
	
		
		Cookie cookie = new Cookie(productId+"",productCount+"");
	
		cookie.setMaxAge(60*60*24*7);		
		resp.addCookie(cookie);
		
		
		return new ResponseEntity<RespCM> (new RespCM(200,"ok"),HttpStatus.OK);
	}

	@PostMapping("/product/billProc")
	public String billProc(@RequestParam ("id") int [] id, @RequestParam ("count") int[] count,HttpServletRequest request,HttpServletResponse response,Model model) {

		int userId = 1;
		
		pservice.payment(id,count);		
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null){
			
			for(int i=0; i < cookies.length; i++){		
				for(int j=0; j<id.length; j++) {
					if(cookies[i].getName().equals(id[j]+"")) {
						cookies[i].setMaxAge(0);
						//JS 에서 패스설정 "/"을 해주었기 때문에 다시 패스설정을 해주어야하는 듯....
						cookies[i].setPath("/");
						response.addCookie(cookies[i]);
					}
				}
			}	
		}
		
		List<FindAllUserIdBillDto> bills = pservice.findAllUserIdBill(userId);
		model.addAttribute("bills", bills);
		
		
		return "product/bill";
		
	}



}