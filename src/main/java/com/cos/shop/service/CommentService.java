package com.cos.shop.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.shop.model.ReturnCode;
import com.cos.shop.model.comment.dto.ReqDetailDto;
import com.cos.shop.model.comment.dto.RespDetailDto;
import com.cos.shop.model.user.User;
import com.cos.shop.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CommentRepository commentRepository;
	
	public List<RespDetailDto> 댓글목록보기(int boardId) {
		
		return commentRepository.findByBoardId(boardId);
	}
	
	public RespDetailDto 댓글쓰기(ReqDetailDto dto) {
		int result = commentRepository.save(dto);
		
		if(result == 1) { // 댓글쓰기 성공
			//  select
			return commentRepository.findById(dto.getId());
		}else { // 댓글쓰기 실패
			return null;
		}
	}
	
	public List<RespDetailDto> getComment(){
		
		List<RespDetailDto> comments = commentRepository.findAll();
		
		return comments;
		
		
	}
	
	
	public int 댓글삭제(int id) {
		
		// 해당 댓글은 누가 썻냐?
		RespDetailDto comment =commentRepository.findById(id);
		
		// 지금 로그인 주체는 누구냐?
		User principal = (User) session.getAttribute("principal");

//		User principal = userDetailService.getPrincipal();
		if(comment.getUserId() == principal.getId()) {
			return commentRepository.delete(id); // 1, 0, -1
		}else {
			return ReturnCode.권한없음; // -3
		}
		
//		if(principal.getId() == comment.getId()) {
//			return commentRepository.delete(id);
//		}else {
//			return ReturnCode.권한없음;
//		}
		
	}



}