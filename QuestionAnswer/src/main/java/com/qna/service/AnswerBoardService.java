package com.qna.service;

import java.util.List;

import com.qna.domain.AnswerBoard;
import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

public interface AnswerBoardService {

	AnswerBoard save(AnswerBoard answerBoard);

	AnswerBoard findById(int answerBoardId);
	
	void update(int answerBoardId, BoardDto updateParam);

	List<AnswerBoard> findAll(int questionBoardId);

	void delete(AnswerBoard answerBoard);
	
}
