package com.qna.service;

import java.util.List;
import java.util.Optional;

import com.qna.domain.Member;
import com.qna.dto.MemberUpdateDto;

public interface MemberService {

	  Member join(Member member);	  
	 
	  void update(int id, MemberUpdateDto updateParam);

	  Member findByEmail(String email);

	  List<Member> findAll();

	  Member findById(int id);
	
	
}
