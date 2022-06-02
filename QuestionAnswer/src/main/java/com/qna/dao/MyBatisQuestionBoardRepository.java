package com.qna.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.qna.domain.QuestionBoard;

import lombok.RequiredArgsConstructor;


@Repository
@RequiredArgsConstructor
public class MyBatisQuestionBoardRepository implements QuestionBoardRepository {

	private final QuestionBoardMapper questionBoardMapper;
	
	@Override
	public QuestionBoard save(QuestionBoard questionBoard) {

		questionBoardMapper.save(questionBoard);
		return questionBoard;
	}

	@Override
	public Optional<QuestionBoard> findById(int questionBoardId) {
		return questionBoardMapper.findById(questionBoardId);
	}

	@Override
	public List<QuestionBoard> findAll() {
		// TODO Auto-generated method stub
		return questionBoardMapper.findAll();
	}

}
