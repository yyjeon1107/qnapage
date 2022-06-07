package com.qna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.qna.dao.QuestionBoardRepository;
import com.qna.domain.QuestionBoard;
import com.qna.dto.BoardDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class QuestionBoardServiceImpl implements QuestionBoardService {

	
	private final QuestionBoardRepository questionBoardRepository;

	@Override
	public QuestionBoard save(QuestionBoard questionBoard) {
		// TODO Auto-generated method stub
		return questionBoardRepository.save(questionBoard);
	}

	@Override
	public QuestionBoard findById(int questionBoardId) {
		// TODO Auto-generated method stub
		return questionBoardRepository.findById(questionBoardId);
	}

	@Override
	public List<QuestionBoard> findAll() {
		// TODO Auto-generated method stub
		return questionBoardRepository.findAll();
	}

	@Override
	public void update(int questionBoardId, BoardDto updateParam) {
		// TODO Auto-generated method stub
		questionBoardRepository.update(questionBoardId, updateParam);
	}

	@Override
	public void delete(QuestionBoard questionBoard) {
		// TODO Auto-generated method stub
		questionBoardRepository.delete(questionBoard);
	}
	
	
}
