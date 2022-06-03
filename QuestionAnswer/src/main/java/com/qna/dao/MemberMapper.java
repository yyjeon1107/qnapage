package com.qna.dao;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.qna.domain.Member;
import com.qna.dto.MemberUpdateDto;

@Mapper
public interface MemberMapper {

	
	void save(Member member);
	
	void update(@Param("id") int id, @Param("updateParam") MemberUpdateDto updateParam);
	
	Member findByEmail(String email);
	
	List<Member> findAll();

	Member findById(int id);
	
}
