package com.qna.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuestionBoard {

	private int id;
	private int memberId;
	private String title;
	private String content;
	
	
}
