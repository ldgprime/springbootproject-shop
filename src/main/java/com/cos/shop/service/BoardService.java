package com.cos.shop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.shop.model.board.dto.ReqUpdateDto;
import com.cos.shop.model.board.dto.ReqWriteDto;
import com.cos.shop.model.board.dto.RespBoardDto;
import com.cos.shop.repository.BoardRepository;

@Service
public class BoardService {
	
	@Autowired
	private BoardRepository brepository;
	
	public int boardWriteProc(ReqWriteDto dto) {
	
		int result = brepository.boardWriteProc(dto); 
		
		return result;
	}
	
	public List<RespBoardDto> findAllProductId(int productId){
		
		List<RespBoardDto> boards = brepository.findAllProductId(productId);
				
		return boards;
	}
	
	public RespBoardDto findById(int boardId) {
		
		RespBoardDto board = brepository.findById(boardId);
		
		return board;
	}
	
	public int updateProc(ReqUpdateDto dto) {
		return brepository.updateProc(dto);
	}
	
	public int delete(int boardId) {
		return brepository.delete(boardId);
	}



}