package com.qna.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.qna.domain.QuestionBoard;

@Mapper
public interface QuestionBoardMapper {

	void save(QuestionBoard questionBoard);
	
	Optional<QuestionBoard> findById(int questionBoardId);
	
	List<QuestionBoard> findAll();
}
