package com.qna.service;

import java.util.List;
import java.util.Optional;

import com.qna.domain.QuestionBoard;

public interface QuestionBoardService {

	QuestionBoard save(QuestionBoard questionBoard);

	QuestionBoard findById(int questionBoardId);

	List<QuestionBoard> findAll();
	
	
}
