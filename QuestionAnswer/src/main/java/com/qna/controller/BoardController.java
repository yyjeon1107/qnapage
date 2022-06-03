package com.qna.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qna.domain.Member;
import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;
import com.qna.service.MemberService;
import com.qna.service.QuestionBoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	
	private final QuestionBoardService questionBoardService;
	private final MemberService memberService;
	
	//게시판 글 작성
	@GetMapping("/add/{email}")
	public String getAddBoard(@PathVariable String email) {
		Member member = memberService.findByEmail(email);
		return "board/form";
	}
	
	@PostMapping("/add/{email}")
	public String postAddBoard(@PathVariable String email, @ModelAttribute QuestionBoard questionBoard) {
		
		
		Member member = memberService.findByEmail(email);
		QuestionBoard saveQuestionBoard = questionBoardService.save(questionBoard);
		return "board/form";
	}
	
	
	
	@GetMapping("/list")
	public String board(Model model) {
		
		List<QuestionBoard> questionBoardList= questionBoardService.findAll();
		model.addAttribute("boards", questionBoardList);
		
		return "board/list";
	}
	

}
