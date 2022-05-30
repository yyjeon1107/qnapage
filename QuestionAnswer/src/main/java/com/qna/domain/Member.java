package com.qna.domain;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	
	private int id;
	private String name;
	private String password;
	private String email;
	private List<QuestionBoard> questionBoardList;
	

}
