package com.qna.dao;

import java.util.List;
import java.util.Optional;

import com.qna.domain.Member;
import com.qna.dto.MemberUpdateDto;

public interface MemberRepository {

    Member save(Member member);

    void update(int id, MemberUpdateDto updateParam);

    Optional<Member> findByEmail(String email);
    
    Optional<Member> findById(int id);

    List<Member> findAll();

}
