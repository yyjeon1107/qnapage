package com.qna.service;

import java.util.List;

import com.qna.domain.AnswerBoard;
import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;
import com.qna.dto.SelectedDto;

public interface AnswerBoardService {

	AnswerBoard save(AnswerBoard answerBoard);

	AnswerBoard findById(int answerBoardId);
	
	void update(int answerBoardId, BoardDto updateParam);
	
	void updateSelect(int answerBoardId, SelectedDto updateSelectParam);

	List<AnswerBoard> findAll(int questionBoardId);

	void delete(AnswerBoard answerBoard);
	
}
