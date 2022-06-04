package com.qna.dao;

import java.util.List;
import java.util.Optional;

import com.qna.domain.QuestionBoard;

public interface QuestionBoardRepository {

	QuestionBoard save(QuestionBoard questionBoard);
	
	QuestionBoard findById(int questionBoardId);

	List<QuestionBoard> findAll();

	
}
