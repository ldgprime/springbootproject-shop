package com.cos.shop.repository;

import java.util.List;

import com.cos.shop.dto.RequestUserJoinDto;
import com.cos.shop.model.board.Board;
import com.cos.shop.model.user.User;

public interface BoardRepository {
	// 전체보기
	List<Board> findByProductId();
	// 상세보기
	User findById(int id);
	// 회원가입
	int save(RequestUserJoinDto dto);
	// 회원수정
	void update(Board board);
	// 회원삭제
	void delete(int id);
}

