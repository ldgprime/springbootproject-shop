package com.cos.shop.controller;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.ReturnCode;
import com.cos.shop.model.user.User;
import com.cos.shop.model.user.dto.ReqJoinDto;
import com.cos.shop.model.user.dto.ReqLoginDto;
import com.cos.shop.model.user.dto.ReqprofileDto;
import com.cos.shop.service.UserService;

@Controller 
public class UserController {
	
	
	@Autowired
	UserService uService;
	
	@Autowired
	HttpSession session;

	@GetMapping("/user/join")
	public String join() {
		return "user/join";
	}
	@GetMapping("/user/login")
	public String login() {
		return "user/login";
	}

	@GetMapping("/user/profile")
	public String profile() {
		return "user/profile";
	}
	
	@GetMapping("/user/logout")
	public String logout() {
		session.invalidate();
		return "redirect:/";
	}
	
	
	@PostMapping("/user/join")
	public ResponseEntity<?> join(@Valid @RequestBody ReqJoinDto dto) {
		int result = uService.join(dto);
		

		if (result == ReturnCode.아이디중복) {
			return new ResponseEntity<RespCM>(new RespCM(ReturnCode.아이디중복, "아이디중복"), HttpStatus.OK);
		} else if (result == ReturnCode.성공) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		} else {
			return new ResponseEntity<RespCM>(new RespCM(500, "fail"), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping("/user/jusoPopup")
	public String jusoPopup() {

		return "user/jusoPopup";

	}
	
	@PostMapping("/user/login")
	public String login(ReqLoginDto dto) {

		User principal = uService.login(dto);
		session.setAttribute("principal", principal);

		return "redirect:/";
	}
	
	@PutMapping("/user/profileproc")
	public ResponseEntity<?>  profileProc(@RequestBody ReqprofileDto dto) {
		
		int result = uService.profileProc(dto);

		if(result == 1 ) {
			return new ResponseEntity<RespCM> (new RespCM(200,"ok"),HttpStatus.OK);
		}else {
			return new ResponseEntity<RespCM> (new RespCM(500,"ok"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
