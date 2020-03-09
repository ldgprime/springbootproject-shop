package com.cos.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.comment.dto.ReqDetailDto;
import com.cos.shop.model.comment.dto.RespDetailDto;
import com.cos.shop.service.CommentService;

@RestController
public class CommentController {

	@Autowired
	private CommentService commentService;
	
	@PostMapping("/comment/api/write")
	public ResponseEntity<?> write(@RequestBody ReqDetailDto dto) {
		
		RespDetailDto comment = commentService.댓글쓰기(dto);
		
		if(comment != null) {
			comment.setStatus(new RespCM(200, "ok"));
			return new ResponseEntity<RespDetailDto>(comment, HttpStatus.OK);
		}else {
			RespDetailDto error = new RespDetailDto();
			error.setStatus(new RespCM(400, "fail"));
			return new ResponseEntity<RespDetailDto>(error, HttpStatus.BAD_REQUEST);
		}	
	}
	            
	@GetMapping("/comment/api/getcomment/{boardId}")
	public ResponseEntity<?> getComment(@PathVariable int boardId) {
		
		List<RespDetailDto> comments = commentService.댓글목록보기(boardId);
		
		comments.get(0).setStatus(new RespCM(200,"ok"));
		
		return new ResponseEntity<List<RespDetailDto>>(comments, HttpStatus.OK);
	}
	
	@DeleteMapping("/comment/api/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable int id) {
		
		int result = commentService.댓글삭제(id);
		
		// 해당 댓글은 누가 썻냐?
		
		// 지금 로그인 주체는 누구냐?
		
		if(result == 1) {
			return new ResponseEntity<RespCM>(new RespCM(200, "ok"), HttpStatus.OK);
		}else if(result == -3) {
			return new ResponseEntity<RespCM>(new RespCM(403, "fail"), HttpStatus.FORBIDDEN);
		}else {
			return new ResponseEntity<RespCM>(new RespCM(400, "fail"), HttpStatus.BAD_REQUEST);
		}
		
	}



}
