package com.qna.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

	private int questionBoardId;
	private String memberName;
	private String title;
	private String content;
	
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}


	public BoardDto(int questionBoardId, String memberName, String title, String content) {
		super();
		this.questionBoardId = questionBoardId;
		this.memberName = memberName;
		this.title = title;
		this.content = content;
	}
	
	
	
	
	
	
}
