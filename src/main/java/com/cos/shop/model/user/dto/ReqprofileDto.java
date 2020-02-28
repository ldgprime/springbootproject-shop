package com.cos.shop.model.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ReqprofileDto {
	private int id;
	private String password;
	private String email;
	private String phone;
	private String address;
}
