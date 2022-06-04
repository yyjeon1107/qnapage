package com.qna.dto;

import lombok.Data;

@Data
public class MemberUpdateDto {

	private int id;
	private String email;
	private String name;
	private String password;
	
	
	public MemberUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public MemberUpdateDto(int id, String email, String name, String password) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
	}






	
	
	
	
}
