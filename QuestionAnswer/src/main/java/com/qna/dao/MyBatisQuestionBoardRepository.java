package com.qna.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

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
	public QuestionBoard findById(int questionBoardId) {
		return questionBoardMapper.findById(questionBoardId);
	}

	@Override
	public List<QuestionBoard> findAll() {
		// TODO Auto-generated method stub
		return questionBoardMapper.findAll();
	}

	@Override
	public void update(int id, BoardDto updateParam) {
		// TODO Auto-generated method stub
		questionBoardMapper.update(id, updateParam);
	}

	@Override
	public void delete(QuestionBoard questionBoard) {
		// TODO Auto-generated method stub
		questionBoardMapper.delete(questionBoard);
	}

}
