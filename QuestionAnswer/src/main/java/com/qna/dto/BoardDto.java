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
    private LocalDateTime ModDtime;
	private int anserBoardId;
	private int selected;
	
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardDto(int questionBoardId, String memberName, String title, String content, LocalDateTime modDtime,
			int anserBoardId, int selected) {
		super();
		this.questionBoardId = questionBoardId;
		this.memberName = memberName;
		this.title = title;
		this.content = content;
		ModDtime = modDtime;
		this.anserBoardId = anserBoardId;
		this.selected = selected;
	}


	
	
	
	
	
	
}
