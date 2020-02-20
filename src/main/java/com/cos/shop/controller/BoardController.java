package com.cos.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/board/boardWrite")
	public String boardWrite() {
		return "/board/boardwrite";
	}
	@GetMapping("/board/boardupdate")
	public String boardupdate() {
		return "/board/boardupdate";
	}

	@GetMapping("/board/boarddetail")
	public String boardDetail() {
		return "/board/boarddetail";
	}

}
