package com.qna.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.qna.domain.QuestionBoard;

@Mapper
public interface QuestionBoardMapper {

	@Insert("INSERT INTO questionBoard(member_id, qboard_title, qboard_content) VALUES("
			+ "#{questionBoard.id}, " //
			+ "#{questionBoard.title}, "
			+ "#{questionBoard.content})" //
	)
	int insert(@Param("questionBoard") QuestionBoard questionBoard);
		
	@Select("SELECT * FROM questionBoard")
	@Results(id="QBoardMap", value={ //재사용 위한 id 설정
		@Result(property="id", column="qboard_id"), // 
		@Result(property="title", column="qboard_title"), //java 객체와 실제 column이 다를때 매핑
		@Result(property="content", column="qboard_content")
	})
	List<QuestionBoard> getAll();
	
	
	@Select("SELECT * FROM questionBoard WHERE id=#{id}")
	@ResultMap("QBoardMap") //Results 재사용
	QuestionBoard getById(@Param("id") int id);
	
	@Select("SELECT * FROM qusestionBoard WHERE member_id=#{memberId}")
	@ResultMap("QBoardMap")
	List<QuestionBoard> getByMemberId(@Param("memberId") int memberId);
	
}
