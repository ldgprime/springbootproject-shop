package com.cos.shop.repository;

import java.util.List;

import com.cos.shop.model.board.dto.ReqUpdateDto;
import com.cos.shop.model.board.dto.ReqWriteDto;
import com.cos.shop.model.board.dto.RespBoardDto;

public interface BoardRepository {

	public int boardWriteProc(ReqWriteDto dto);
	
	public List<RespBoardDto> findAllProductId(int productId);
	
	public RespBoardDto findById(int boardId);
	
	public int updateProc(ReqUpdateDto dto);
	
	public int delete(int boardId);
}

