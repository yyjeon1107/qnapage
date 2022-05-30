package com.qna.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qna.dao.MemberMapper;
import com.qna.domain.Member;



@org.springframework.web.bind.annotation.RestController
@RequestMapping("/rest")
public class RestController {

	@Autowired
	private MemberMapper memberMapper;
	
//	@PostMapping("/")
//	public int post(@RequestBody Member member) {
//		return memberMapper.insert(member);
//	}
//	
}
