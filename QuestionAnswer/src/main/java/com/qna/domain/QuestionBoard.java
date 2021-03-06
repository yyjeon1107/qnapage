package com.qna.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
public class QuestionBoard {

	
	private int questionBoardId;
	private String memberName;
	private String title;
	private String content;

	
	//등록일자
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime RegDtime;
	
	//수정일자
	@JsonFormat(pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
    private LocalDateTime ModDtime;

	public QuestionBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionBoard(int questionBoardId, String memberName, String title, String content, LocalDateTime regDtime,
			LocalDateTime modDtime) {
		super();
		this.questionBoardId = questionBoardId;
		this.memberName = memberName;
		this.title = title;
		this.content = content;
		RegDtime = regDtime;
		ModDtime = modDtime;
	}

	

	



	
}
