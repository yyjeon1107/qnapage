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
import com.qna.dto.MemberUpdateDto;
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
	
		
	//게시판 글 수정
	@GetMapping("/edit/{questionBoardId}")
	public String getEditBoard(@PathVariable("questionBoardId") int questionBoardId, Model model) {
		QuestionBoard questionboard = questionBoardService.findById(questionBoardId);
		System.out.println(questionBoardService.findById(questionBoardId));
		model.addAttribute("questionboard", questionboard);
		return "/board/editform";
	}
		
	@PostMapping("/edit/{questionBoardId}")
	public String postEditBoard(@PathVariable("questionBoardId") int questionBoardId, @ModelAttribute BoardDto updateParam){
		questionBoardService.update(questionBoardId, updateParam);
		return "redirect:/board/list";
	}
	
	
	
	//게시판 글 리스트 조회
	@GetMapping("/list")
	public String boardList(Model model) {		
		List<QuestionBoard> questionBoardList= questionBoardService.findAll();
		model.addAttribute("boards", questionBoardList);		
		return "board/list";
	}
	
	
	//게시판 글 삭제	
	@GetMapping("/delete/{questionBoardId}")
	public String deleteBoard(@PathVariable("questionBoardId") int questionBoardId) {
		QuestionBoard questionboard = questionBoardService.findById(questionBoardId);
		questionBoardService.delete(questionboard);
		System.out.println("삭제 성공");
		return "redirect:/board/list";
	}

}
