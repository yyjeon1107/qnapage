package com.qna.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionBoard {

	
	private int questionBoardId;
	private String memberName;
	private String title;
	private String content;
	private String answerBoardId;
	//List <AnswerBoard> answerBoardList; //1:N 관계
	
	//등록일자
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime RegDtime;
	
	//수정일자
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private LocalDateTime ModDtime;

	
}
