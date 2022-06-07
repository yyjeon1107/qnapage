package com.qna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qna.domain.AnswerBoard;
import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

public interface AnswerBoardRepository {

	AnswerBoard save(@Param("answerboard") AnswerBoard answerBoard);
	
	AnswerBoard findById(int answerBoardId);
	
	void update(@Param("answerBoardId") int answerBoardId, @Param("updateParam") BoardDto updateParam);
	
	List<AnswerBoard> findAll(int questionBoardId);
	
	void delete(AnswerBoard answerBoard);
	
}
