package com.cos.shop.model.nice.dto;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.nice.Nice;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespNiceDto {
	
	private Nice nice; 
	private RespCM respCM;
	
	

}
