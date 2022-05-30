package com.qna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qna.domain.Member;

@Mapper
public interface MemberMapper {

	
	@Insert("INSERT INTO member(id, name, password, email) VALUES("
			+ "#{member.id}, "
			+ "#{member.name}, "
			+ "#{member.password}, "//
			+ "#{member.email})" //
	)
	@Options(useGeneratedKeys = true, keyProperty="id")
	int insert(@Param("member") Member member);
		
	@Select("SELECT * FROM member")
	@Results(id="MemberMap", value={ //재사용 위한 id 설정
		@Result(property="id", column="id"), // 
		@Result(property="name", column="name"), //java 객체와 실제 column이 다를때 매핑
		@Result(property="password", column="password"),
		@Result(property="email", column="email"),
//		@Result(property="questionBoardList", column="id", many=@Many(select="com.qna.QuestionBoardMapper.getByMemberId"))
	})
	List<Member> getAll();
	
	
	@Select("SELECT * FROM member WHERE id=#{id}")
	@ResultMap("MemberMap") //Results 재사용
	Member getById(@Param("id") int id);

	
	@Select("SELECT * FROM member WHERE email=#{email}")
	@ResultMap("MemberMap")
	Member getByEmail(@Param("email") String email);
	
	
	
	
	
	}
