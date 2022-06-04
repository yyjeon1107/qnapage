package com.qna.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	@GetMapping("/add/{id}")
	public String getAddBoard(@PathVariable("id") int id) {
		Member member = memberService.findById(id);
		return "board/form";
	}
	
	@PostMapping("/add/{id}")
	public String postAddBoard(@PathVariable("id") int id, @ModelAttribute QuestionBoard questionBoard) {
		
		Member member = memberService.findById(id);
		String memberName = member.getName();
		questionBoard.setMemberName(memberName);
		QuestionBoard saveQuestionBoard = questionBoardService.save(questionBoard);
		return "redirect:/board/list";
	}
	
	
	
	@GetMapping("/list")
	public String board(Model model) {
		
		List<QuestionBoard> questionBoardList= questionBoardService.findAll();
		model.addAttribute("boards", questionBoardList);
		
		return "board/list";
	}
	

}
