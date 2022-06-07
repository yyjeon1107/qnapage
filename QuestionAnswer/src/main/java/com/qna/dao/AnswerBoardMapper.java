package com.qna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qna.domain.AnswerBoard;
import com.qna.dto.BoardDto;

@Mapper
public interface AnswerBoardMapper {

	void save(@Param("answerboard") AnswerBoard answerBoard);
	
	AnswerBoard findById(int answerBoardId);
	
	void update(@Param("answerBoardId") int answerBoardId, @Param("updateParam") BoardDto updateParam);
	
	List<AnswerBoard> findAll(int questionBoardId);
	
	void delete(AnswerBoard answerBoard);
	
}
