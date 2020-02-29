package com.cos.shop.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.shop.model.bill.dto.BillDto;
import com.cos.shop.model.bill.dto.FindAllUserIdBillDto;
import com.cos.shop.model.payment.Payment;
import com.cos.shop.model.payment.dto.PaymentDto;
import com.cos.shop.model.product.Product;
import com.cos.shop.model.product.dto.RespAddCart;
import com.cos.shop.repository.BillRepository;
import com.cos.shop.repository.PaymentRepository;
import com.cos.shop.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository pRepository;
	
	@Autowired
	BillRepository bRepository;
	
	@Autowired
	PaymentRepository payRepository;
	
	
	public List<Product> findAllProduct(){
		
		List<Product> products = pRepository.findAll();
		
		return products;
		
	}
	
	
	public Product findByIdProduct(int productId){
		
		Product product = pRepository.findById(productId);
		
		return product;
		
	}
	
	
	public RespAddCart findByIdAddCartProduct(int productId){
		
		RespAddCart respAddCart = pRepository.findByIdAddCart(productId);
		
		return respAddCart;
		
	}
	
	@Transactional
	public void payment(int[] id, int[] count, int userId){
		
		List<Product> products = new ArrayList<Product>();
		List<Integer> subPriceSum = new ArrayList<Integer>(); 
		int subPrice = 0;
		int totalPrice = 0;
		int totalCount = 0;		
		for(int i=0; i<id.length; i++) {
			Product product = pRepository.findById(id[i]);
			products.add(product);
		}
		
		for(int i = 0; i<count.length; i++) {
			subPrice = products.get(i).getProductPrice()*count[i];
			totalPrice += subPrice;
			totalCount += count[i]; 
			subPriceSum.add(subPrice);
		}		
	
		PaymentDto pDto = new PaymentDto().builder()
				.totalCount(totalCount)
				.totalPrice(totalPrice)
				.userId(userId)
				.build();
		
		payRepository.payment(pDto);
		
		for(int i = 0; i<id.length; i++) {
			
			BillDto bDto = new BillDto().builder()
					.subCount(count[i])
					.subPrice(subPriceSum.get(i))
					.userId(userId)
					.productId(id[i])
					.paymentId(pDto.getId())
					.build();
			
			
			bRepository.bill(bDto);
		}	
		
	}
	
	public List<FindAllUserIdBillDto> findAllUserIdBill(int userId){
		
		List<FindAllUserIdBillDto> bills = bRepository.findAllUserIdBill(userId);	
		
		
		return bills;
	}

	public List<Payment> findAllUserIdPayment(int userId){
		
		
		List<Payment> payments = payRepository.FindAllUserIdPayment(userId);
		
		return payments;
	}
	
	public List<Product> findByKeyword(String keyword){			
		List<Product> products = pRepository.findByKeyword(keyword);	
		return products;		
	}
	
	
	
	
	

}