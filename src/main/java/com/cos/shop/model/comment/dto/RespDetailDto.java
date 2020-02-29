package com.cos.shop.model.comment.dto;

import java.sql.Date;
import java.sql.Timestamp;

import com.cos.shop.model.RespCM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RespDetailDto {// 익스텐즈로 상속해도 됨
	
	private RespCM status;
	
	private int id;
	private int userId;
	private int boardId;
	private int productId;
	private String content;
	private Date createDate;
	private String username;
}
