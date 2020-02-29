package com.cos.shop.repository;

import java.util.List;

import com.cos.shop.model.comment.dto.ReqDetailDto;
import com.cos.shop.model.comment.dto.RespDetailDto;
import com.cos.shop.model.board.Board;
import com.cos.shop.model.user.User;

public interface CommentRepository {

	public int save(ReqDetailDto dto);
	public RespDetailDto findById(int id);
	public int delete(int id);
	public List<RespDetailDto> findByBoardId(int boardId);
}

