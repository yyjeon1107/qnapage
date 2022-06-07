package com.qna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

@Mapper
public interface QuestionBoardMapper {

	void save(@Param("questionboard") QuestionBoard questionBoard);
	
	QuestionBoard findById(int questionBoardId);
	
	void update(@Param("questionBoardId") int id, @Param("updateParam") BoardDto updateParam);
	
	List<QuestionBoard> findAll();
	
	void delete(QuestionBoard questionBoard);

}
