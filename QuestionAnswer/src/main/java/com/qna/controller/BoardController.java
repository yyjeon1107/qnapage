package com.qna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/board")
public class BoardController {

	
	@GetMapping("/list")
	public String boardList() {
		return "board/list";
	}
	
	
	
//	@GetMapping("/list")
//	public String board(Model model) {
//		
//		
//		List<TodoListDomain> boards = todoListRepository.findAll();
//		model.addAttribute("boards", boards);
//		
//		return "board/list";
//	}
//	
//	
//	
//	@GetMapping("/form")
//	public String form(Model model, @RequestParam(required=false) Long id) {
//		
//		if(id == null) {
//			model.addAttribute("board", new TodoListDomain());
//		}else {//값이 있을 경우
//			TodoListDomain board = todoListRepository.findById(id).orElse(null);
//			model.addAttribute("board", board);
//		}
//				
//		return "board/form";
//	}
//	
//	
//	@PostMapping("/form")
//	public String form(@ModelAttribute TodoListDomain board) {
//		
//		todoListRepository.save(board);
//		return "redirect:/board/list";
//	}
	
	
}
