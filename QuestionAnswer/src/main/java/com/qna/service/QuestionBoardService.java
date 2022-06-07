package com.qna.service;

import java.util.List;
import java.util.Optional;

import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

public interface QuestionBoardService {

	QuestionBoard save(QuestionBoard questionBoard);

	QuestionBoard findById(int questionBoardId);
	
	void update(int questionBoardId, BoardDto updateParam);

	List<QuestionBoard> findAll();

	void delete(QuestionBoard questionBoard);
	
	
}
