package com.cos.shop.model.product.dto;

import com.cos.shop.model.RespCM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespHateCount {
	
	private RespCM respCM;
	private int hateCount;
}
