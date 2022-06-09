package com.qna.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

	
	private int questionBoardId;
	private String memberName;
	private String title;
	private String content;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	@LastModifiedDate
    private LocalDateTime ModDtime;
	
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardDto(int questionBoardId, String memberName, String title, String content, LocalDateTime modDtime) {
		super();
		this.questionBoardId = questionBoardId;
		this.memberName = memberName;
		this.title = title;
		this.content = content;
		ModDtime = modDtime;
	}


	
	
	
	
	
	
}
