package com.cos.shop.model.hate.dto;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.hate.Hate;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespHateDto {

	private Hate hate; 
	private RespCM respCM;
}
