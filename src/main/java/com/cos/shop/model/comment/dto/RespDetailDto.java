package com.cos.shop.model.comment.dto;

import java.sql.Date;

import com.cos.shop.model.RespCM;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RespDetailDto {

	
	private RespCM status;
	
	private int id;
	private int userId;
	private int boardId;
	private int productId;
	private String content;
	private Date createDate;
	private String username;
}
