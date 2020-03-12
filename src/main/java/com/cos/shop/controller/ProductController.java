package com.cos.shop.controller;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cos.shop.model.PageMaker;
import com.cos.shop.model.RespCM;
import com.cos.shop.model.bill.dto.FindAllUserIdBillDto;
import com.cos.shop.model.board.Board;
import com.cos.shop.model.board.dto.RespBoardDto;
import com.cos.shop.model.payment.Payment;
import com.cos.shop.model.product.Product;
import com.cos.shop.model.product.dto.RespAddCart;
import com.cos.shop.model.user.User;
import com.cos.shop.service.BoardService;
import com.cos.shop.service.HateService;
import com.cos.shop.service.NiceService;
import com.cos.shop.service.ProductService;
import com.cos.shop.service.ReviewService;

@Controller 
public class ProductController {
	
	
	@Autowired
	private ProductService pservice;
	
	@Autowired
	private NiceService nservice;
	
	@Autowired
	private HateService hservice;
	
	@Autowired
	private ReviewService rservice;
	
	@Autowired
	private BoardService bservice;
	
	@Autowired
	private HttpSession session;
	
	
	@GetMapping({"/","","/index"})
	public String index() {
		return "index";
	}

	@GetMapping("/product/bill")
	public String bill(Model model) {
		User principal = (User) session.getAttribute("principal");
		int userId = principal.getId();
		
		List<FindAllUserIdBillDto> bills = pservice.findAllUserIdBill(userId);
		model.addAttribute("bills", bills);
		List<Payment> payments = pservice.findAllUserIdPayment(userId);
		model.addAttribute("payments", payments);
		
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
		
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			
			Product product = pservice.findByIdProduct(productId);
			
			model.addAttribute("product", product);				
			
					
			return "product/productdetail";
		
		}
		
		
		int userId = principal.getId();
		
		Product product = pservice.findByIdProduct(productId);
		
		model.addAttribute("product", product);
		
		int niceResult = nservice.findByUserIdProductId(userId, productId);			
		
		model.addAttribute("niceResult", niceResult);
		
		int hateResult = hservice.findByUserIdProductId(userId, productId);
		
		model.addAttribute("hateResult", hateResult);		
	
	
		return "product/productdetail";
	}
	
	@GetMapping("/product/productdetail//api/{productId}/{productCount}")
	public ResponseEntity<?> addCart(@PathVariable int productId, @PathVariable int productCount, HttpServletResponse resp ){
		
	
		
		Cookie cookie = new Cookie(productId+"",productCount+"");
	
		cookie.setMaxAge(60*60*24*7);		
		resp.addCookie(cookie);
		
		
		return new ResponseEntity<RespCM> (new RespCM(200,"ok"),HttpStatus.OK);
	}

	@PostMapping("/product/cartProc")
	public String billProc(@RequestParam ("id") int [] id, @RequestParam ("count") int[] count,HttpServletRequest request,HttpServletResponse response,Model model) {
		
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			response.setContentType("text/html; charset=UTF-8");		
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>");
				out.print("alert('로그인이 필요합니다.');");
				out.print("location.href='/user/login';");			
				out.print("</script>");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		int userId = principal.getId();
		
		pservice.payment(id,count,userId);		
		
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
		List<Payment> payments = pservice.findAllUserIdPayment(userId);
		model.addAttribute("payments", payments);
		
		
		return "product/bill";
		
	}

	@PostMapping("/product/productsearch")
	public String product(@RequestParam ("keyword") String keyword, Model model) {	
		

		List<Product> products = pservice.findByKeyword(keyword);		
		model.addAttribute("products", products);
		
		return "product/product";
		
	}


}