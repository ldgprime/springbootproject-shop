package com.cos.shop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cos.shop.model.RespCM;
import com.cos.shop.model.board.dto.ReqUpdateDto;
import com.cos.shop.model.board.dto.ReqWriteDto;
import com.cos.shop.model.board.dto.RespBoardDto;
import com.cos.shop.model.user.User;
import com.cos.shop.model.user.dto.ReqprofileDto;
import com.cos.shop.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private BoardService bservice;

	@GetMapping("/board/boardwrite/{productId}")
	public String boardWrite(@PathVariable int productId,  Model model, HttpServletResponse response ) {
		
		User principal = (User) session.getAttribute("principal");
		if(principal == null) {
			response.setContentType("text/html; charset=UTF-8");		
			PrintWriter out;
			try {
				out = response.getWriter();
				out.print("<script>");
				out.print("alert('로그인이 필요합니다.');");
				out.print("location.href='/user/login';");			
				out.print("</script>");
				out.flush();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		}
		
		model.addAttribute("productId", productId);
		
		return "board/boardwrite";
	}
	
	@PostMapping("/board/boardwirteproc")
	public String boardWriteProc(ReqWriteDto dto) {
		
		int result = bservice.boardWriteProc(dto); 
		
		if(result == 1) {
		return "redirect:/product/productdetail/"+dto.getProductId()+"";
		}
		
		return "product/product";
	}
	
	
	@GetMapping("/board/boardupdate/{boardId}")
	public String boardupdate(@PathVariable int boardId, Model model) {
		
		RespBoardDto board = bservice.findById(boardId);
		model.addAttribute("board", board);		
		
		return "board/boardupdate";
		
	}

	
	@GetMapping("/board/boarddetail/{boardId}")
	public String boardDetail(@PathVariable int boardId, Model model) {
		
		RespBoardDto board = bservice.findById(boardId);
		model.addAttribute("board", board);
		
		return "board/boarddetail";
	}

	@PutMapping("/board/updateproc")
	public ResponseEntity<?> updateProc(@RequestBody ReqUpdateDto dto) {
		
		int result = bservice.updateProc(dto);

		if(result == 1 ) {
			return new ResponseEntity<RespCM> (new RespCM(200,"ok"),HttpStatus.OK);
		}else {
			return new ResponseEntity<RespCM> (new RespCM(500,"ok"),HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/board/boarddelete/{productId}/{boardId}")
	public String boardDelete(@PathVariable int productId, @PathVariable int boardId) {
		
		bservice.delete(boardId); 
		
		
		return "redirect:/product/productdetail/"+productId+"";
	}
	
}
