package com.qna.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qna.dao.MemberMapper;
import com.qna.dao.QuestionBoardMapper;
import com.qna.domain.Member;

@Service
public class MemberService {

	@Autowired
	private MemberMapper memberMapper;
	
	@Autowired
	private QuestionBoardMapper questionBoardMapper;
	
	

	
	
	public List<Member> getAll(){
		List<Member> memberList = memberMapper.getAll();
		
		if(memberList !=null && memberList.size() > 0) {
			for(Member member : memberList) {
				member.setQuestionBoardList(questionBoardMapper.getByMemberId(member.getId()));
			}
		}
		return memberList;
	}
	
	
	@Transactional(rollbackFor=Exception.class)
	public Member add(Member member) throws Exception{
		memberMapper.insert(member);
		if(true) {
			throw new Exception("Exception");
		}
		return member;
	}
	
}
