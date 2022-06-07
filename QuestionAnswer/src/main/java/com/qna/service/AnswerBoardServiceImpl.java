package com.qna.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.qna.dao.AnswerBoardRepository;
import com.qna.dao.QuestionBoardRepository;
import com.qna.domain.AnswerBoard;
import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswerBoardServiceImpl implements AnswerBoardService {

	private final AnswerBoardRepository answerBoardRepository;
	
	@Override
	public AnswerBoard save(AnswerBoard answerBoard) {
		// TODO Auto-generated method stub
		return answerBoardRepository.save(answerBoard);
	}

	@Override
	public AnswerBoard findById(int answerBoardId) {
		// TODO Auto-generated method stub
		return answerBoardRepository.findById(answerBoardId);
	}

	@Override
	public void update(int answerBoardId, BoardDto updateParam) {
		// TODO Auto-generated method stub
		answerBoardRepository.update(answerBoardId, updateParam);
	}

	@Override
	public List<AnswerBoard> findAll(int questionBoardId) {
		// TODO Auto-generated method stub
		return answerBoardRepository.findAll(questionBoardId);
	}

	@Override
	public void delete(AnswerBoard answerBoard) {
		// TODO Auto-generated method stub
		answerBoardRepository.delete(answerBoard);
	}

}
