package com.qna.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qna.dao.MemberRepository;
import com.qna.domain.Member;
import com.qna.dto.MemberUpdateDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{
	

	    private final MemberRepository memberRepository;

	    @Override
	    public Member join(Member member) {
	    	
	    	return memberRepository.save(member);

	    }

	    @Override
	    public void update(int id, MemberUpdateDto updateParam) {
	    	memberRepository.update(id, updateParam);
	    }

	    @Override
	    public Member findByEmail(String email) {
	        return memberRepository.findByEmail(email);
	    }

	    @Override
	    public List<Member> findAll() {
	        return memberRepository.findAll();
	    }

		@Override
		public Member findById(int id) {
			// TODO Auto-generated method stub
			return memberRepository.findById(id);
		}

	
		@Override
		public void delete(Member member) {
			// TODO Auto-generated method stub
			memberRepository.delete(member);
		}

		
	
}
