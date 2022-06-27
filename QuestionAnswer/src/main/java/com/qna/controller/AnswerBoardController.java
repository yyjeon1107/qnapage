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
import com.qna.dto.SelectedDto;
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
	
	//게시판 글 작성
	@GetMapping("/add/{questionBoardId}")
	public String getAddBoard(@PathVariable("questionBoardId") int questionBoardId, Model model) {
		QuestionBoard questionBoard = questionBoardService.findById(questionBoardId);
		model.addAttribute("board", questionBoard);
		return "answer/form";
	}
	
	@PostMapping("/add/{questionBoardId}")
	public String postAddBoard(@PathVariable("questionBoardId") int questionBoardId, @ModelAttribute AnswerBoard answerBoard) {
		answerBoard.setQuestionBoardId(questionBoardId);
		AnswerBoard saveAnswerBoard = answerBoardService.save(answerBoard);
		return "redirect:/answer/list/{questionBoardId}";
	}
	
		
	//게시판 글 수정
	@GetMapping("/edit/{questionBoardId}/{answerBoardId}")
	public String getEditBoard(@PathVariable("questionBoardId") int questionBoardId, @PathVariable("answerBoardId") int answerBoardId, Model model) {
		List<AnswerBoard> answerBoardList = answerBoardService.findAll(questionBoardId);
		AnswerBoard answerBoard = answerBoardService.findById(answerBoardId);
		model.addAttribute("board", answerBoard);
		return "/answer/editform";
	}
		
	@PostMapping("/edit/{questionBoardId}/{answerBoardId}")
	public String postEditBoard(@PathVariable("questionBoardId") int questionBoardId, @PathVariable("answerBoardId") int answerBoardId, @ModelAttribute BoardDto updateParam){
		List<AnswerBoard> answerBoardList = answerBoardService.findAll(questionBoardId);
		AnswerBoard answerBoard = answerBoardService.findById(answerBoardId);
		answerBoardService.update(answerBoardId, updateParam);
		return "redirect:/answer/list/{questionBoardId}";
	}
	
	
	//게시판 글 보기
	@GetMapping("/view/{questionBoardId}/{answerBoardId}")
	public String viewBoard(@PathVariable("questionBoardId") int questionBoardId, @PathVariable("answerBoardId") int answerBoardId, Model model) {
		AnswerBoard answerBoard = answerBoardService.findById(answerBoardId);
		model.addAttribute("board", answerBoard);	
		return "/answer/viewform";
	}
	
	
	//게시판 글 리스트 조회
	@GetMapping("/list/{questionBoardId}")
	public String boardList(@PathVariable("questionBoardId") int questionBoardId, Model model) {		
		List<AnswerBoard> answerBoardList= answerBoardService.findAll(questionBoardId);
		model.addAttribute("boards", answerBoardList);
		return "/answer/list";		
	}
	
	
	//게시판 글 삭제	
	@GetMapping("/delete/{questionBoardId}/{answerBoardId}")
	public String deleteBoard(@PathVariable("questionBoardId") int questionBoardId, @PathVariable("answerBoardId") int answerBoardId) {
		AnswerBoard answerBoard = answerBoardService.findById(answerBoardId);
		answerBoardService.delete(answerBoard);		
	
		return "redirect:/board/list";
	}

//	//게시판 글 채택
//	@GetMapping("/select/{questionBoardId}/{answerBoardId}")
//	public String selectBoard(@PathVariable("questionBoardId") int questionBoardId, @PathVariable("answerBoardId") int answerBoardId, @ModelAttribute SelectedDto updateSelectParam) {
//		
//		AnswerBoard answerBoard = answerBoardService.findById(answerBoardId);		
//		answerBoard.setSelected(1);
//		answerBoardService.updateSelect(answerBoardId, updateSelectParam);
//		System.out.println("===================");
//		System.out.println(answerBoard);
//		System.out.println("===================");
//		return "redirect:/board/list";
//	}

//	//게시판 글 채택 취소
//	@GetMapping("/no/select/{questionBoardId}/{answerBoardId}")
//	public String noSelectBoard(@PathVariable("questionBoardId") int questionBoardId, @PathVariable("answerBoardId") int answerBoardId, @ModelAttribute BoardDto updateParam) {
//		
//		AnswerBoard answerBoard = answerBoardService.findById(answerBoardId);
//		answerBoard.setSelected(0);
//		answerBoardService.updateSelect(answerBoardId, updateParam);		
//
//		return "redirect:/board/list";
//	}
//
//	
}
