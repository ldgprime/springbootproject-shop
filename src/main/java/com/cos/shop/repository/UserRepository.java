package com.cos.shop.repository;

import com.cos.shop.model.user.User;
import com.cos.shop.model.user.dto.ReqJoinDto;
import com.cos.shop.model.user.dto.ReqLoginDto;
import com.cos.shop.model.user.dto.ReqprofileDto;


public interface UserRepository {
	
	int save(ReqJoinDto dto);
	
	int findByUsername(String username); 

	User findByUsernameAndPassword(ReqLoginDto dto);
	
	int updateProfile(ReqprofileDto dto);
	
}
