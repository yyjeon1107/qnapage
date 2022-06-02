package com.qna.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.qna.domain.Member;
import com.qna.dto.MemberUpdateDto;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class MyBatisMemberRepository implements MemberRepository {

	
	
	    private final MemberMapper memberMapper;

	    @Override
	    public Member save(Member member) {
	        memberMapper.save(member);
	        return member;
	    }

	    @Override
	    public void update(int id, MemberUpdateDto updateParam) {
	    	memberMapper.update(id, updateParam);
	    }

	    @Override
	    public Optional<Member> findByEmail(String email) {
	        return memberMapper.findByEmail(email);
	    }

	    @Override
	    public List<Member> findAll() {
	        return memberMapper.findAll();
	    }

		@Override
		public Optional<Member> findById(int id) {
			// TODO Auto-generated method stub
			return memberMapper.findById(id);
		}
	
}
