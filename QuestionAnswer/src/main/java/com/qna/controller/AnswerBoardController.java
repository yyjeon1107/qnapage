package com.qna.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qna.domain.AnswerBoard;
import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;
import com.qna.service.AnswerBoardService;
import com.qna.service.MemberService;
import com.qna.service.QuestionBoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/answer")
@RequiredArgsConstructor
public class AnswerBoardController {

	private final AnswerBoardService answerBoardService;
	private final QuestionBoardService questionBoardService;
	private final MemberService memberService;
	
	//게시판 글 작성
	@GetMapping("/add/{questionBoardId}")
	public String getAddBoard(@PathVariable("questionBoardId") int questionBoardId, Model model) {
		QuestionBoard questionBoard = questionBoardService.findById(questionBoardId);
		System.out.println(questionBoard.getQuestionBoardId());
		model.addAttribute("questionBoard", questionBoard);
		return "answer/form";
	}
	
	@PostMapping("/add/{questionBoardId}")
	public String postAddBoard(@PathVariable("questionBoardId") int questionBoardId, @ModelAttribute AnswerBoard answerBoard) {
		
	
		QuestionBoard questionBoard = questionBoardService.findById(questionBoardId);
		questionBoard.getMemberName();
		answerBoard.setQuestionBoardId(questionBoardId);
		AnswerBoard saveAnswerBoard = answerBoardService.save(answerBoard);
		return "redirect:/board/list";
	}
	
		
	//게시판 글 수정
	@GetMapping("/edit/{answerBoardId}")
	public String getEditBoard(@PathVariable("answerBoardId") int answerBoardId, Model model) {
		AnswerBoard answerBoard = answerBoardService.findById(answerBoardId);
		model.addAttribute("answerBoard", answerBoard);
		return "/answer/editform";
	}
		
	@PostMapping("/edit/{answerBoardId}")
	public String postEditBoard(@PathVariable("answerBoardId") int answerBoardId, @ModelAttribute BoardDto updateParam){
		answerBoardService.update(answerBoardId, updateParam);
		return "redirect:/answer/list";
	}
	
	
	
	//게시판 글 리스트 조회
	@GetMapping("/list/{questionBoardId}")
	public String boardList(@PathVariable("questionBoardId") int questionBoardId, Model model) {
		List<AnswerBoard> answerBoardList= answerBoardService.findAll(questionBoardId);		
		model.addAttribute("boards", answerBoardList);		
		return "answer/list";
	}
	
	
	//게시판 글 삭제	
	@GetMapping("/delete/{answerBoardId}")
	public String deleteBoard(@PathVariable("answerBoardId") int answerBoardId) {
		AnswerBoard answerBoard = answerBoardService.findById(answerBoardId);
		answerBoardService.delete(answerBoard);
		return "redirect:/answer/list";
	}

}
