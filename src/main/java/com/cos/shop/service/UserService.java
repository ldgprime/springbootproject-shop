package com.cos.shop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.shop.model.ReturnCode;
import com.cos.shop.model.user.User;
import com.cos.shop.model.user.dto.ReqJoinDto;
import com.cos.shop.model.user.dto.ReqLoginDto;
import com.cos.shop.model.user.dto.ReqprofileDto;
import com.cos.shop.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	

	@Transactional
	public int join(ReqJoinDto dto) {

		try {
			int result = userRepository.findByUsername(dto.getUsername());

			if (result == 1) {
				return ReturnCode.아이디중복;
			} else {
				return userRepository.save(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public User login(ReqLoginDto dto) {
		
		return userRepository.findByUsernameAndPassword(dto);
	}

	public int profileProc(ReqprofileDto dto) {
		return userRepository.updateProfile(dto);
	}
}