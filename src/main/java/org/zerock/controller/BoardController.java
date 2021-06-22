package org.zerock.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor
@Log4j
public class BoardController {
	
	private BoardService service;
	/*
	@Autowired
	public BoardController(BoardService service) {
		this.service = service; (주입된상태)?
	}
	*/
	
	
	@GetMapping("/list")
	public void list(Model model) {
		log.info("board/list method...");
		
		// service getList() 실행 결과를
		List<BoardVO> list = service.getList();
		// model에 attribute로 넣고
		model.addAttribute("list", list);
		// view로 포워드
	}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		
		//service에게 등록 업무 시키고
		service.register(board); // title, content, writer
		
		//redirect 목적지로 정보 전달
		rttr.addFlashAttribute("result", board.getBno());
		
		// /board/list 로 redirect
		return "redirect:/board/list";
	}
}
