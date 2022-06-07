package com.qna.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Param;

import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

public interface QuestionBoardRepository {

	QuestionBoard save(QuestionBoard questionBoard);
	
	QuestionBoard findById(int questionBoardId);

	void update(@Param("questionBoardId") int id, @Param("updateParam") BoardDto updateParam);
	
	List<QuestionBoard> findAll();
	
	void delete(QuestionBoard questionBoard);

	
}
