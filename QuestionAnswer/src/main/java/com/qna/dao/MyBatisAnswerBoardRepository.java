package com.qna.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.qna.domain.AnswerBoard;
import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyBatisAnswerBoardRepository implements AnswerBoardRepository {

	private final AnswerBoardMapper answerBoardMapper;
	
	@Override
	public AnswerBoard save(AnswerBoard answerBoard) {
		// TODO Auto-generated method stub
		answerBoardMapper.save(answerBoard);
		return answerBoard;
	}

	@Override
	public AnswerBoard findById(int answerBoardId) {
		// TODO Auto-generated method stub
		return answerBoardMapper.findById(answerBoardId);
	}

	@Override
	public void update(int answerBoardId, BoardDto updateParam) {
		// TODO Auto-generated method stub
		answerBoardMapper.update(answerBoardId, updateParam);
	}

	@Override
	public List<AnswerBoard> findAll(int questionBoardId) {
		// TODO Auto-generated method stub
		return answerBoardMapper.findAll(questionBoardId);
	}

	@Override
	public void delete(AnswerBoard answerBoard) {
		// TODO Auto-generated method stub
		answerBoardMapper.delete(answerBoard);
	}

}
