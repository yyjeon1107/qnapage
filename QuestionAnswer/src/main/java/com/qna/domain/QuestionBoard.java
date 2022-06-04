package com.qna.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

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
	private int answerBoardId;
	//List <AnswerBoard> answerBoardList; //1:N 관계
	
	//등록일자
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime RegDtime;
	
	//수정일자
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime ModDtime;

	public QuestionBoard() {
		super();
		// TODO Auto-generated constructor stub
	}

	public QuestionBoard(int questionBoardId, String memberName, String title, String content, int answerBoardId,
			LocalDateTime regDtime, LocalDateTime modDtime) {
		super();
		this.questionBoardId = questionBoardId;
		this.memberName = memberName;
		this.title = title;
		this.content = content;
		this.answerBoardId = answerBoardId;
		RegDtime = regDtime;
		ModDtime = modDtime;
	}

	



	
}
