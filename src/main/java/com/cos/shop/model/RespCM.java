package com.cos.shop.model;


import com.cos.shop.model.user.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class RespCM {
	
	private int statusCode;
	private String msg;

}
