package com.qna.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.qna.dao.MemberMapper;
import com.qna.domain.Member;
import com.qna.dto.JoinForm;
import com.qna.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@Autowired
	private MemberMapper memberMapper;
	
	
	
	//회원가입
	@GetMapping("/join/member")
	public String getJoin() {
		return "member/joinmembers";
	}
	
	@PostMapping("/join/member")
	public String postJoin(HttpServletRequest request, Model model){
	
		String password = request.getParameter("password"); 
		String name = request.getParameter("name"); 
		String email = request.getParameter("email"); 
		try {
			Member member = new Member();
			member.setPassword(password);
			member.setName(name);
			member.setEmail(email);
			memberMapper.insert(member);
			return "redirect:/";
		}catch (Exception e) {
			// TODO: handle exception
			model.addAttribute("fail", "가입에 실패했습니다.");
			return "member/joinmembers";
		}

	}
	
	
	//로그인
	@GetMapping("/join/login")
	public String getLogin() {
		return "member/login";
	}
	
	@PostMapping("/join/login")
	public String postLogin(HttpServletRequest request, JoinForm joinForm) {
		
		
        HttpSession session = request.getSession();
		Member member = memberMapper.getByEmail(joinForm.getEmail());
		if(member.getPassword().equals(joinForm.getPassword())) {
			
		}
		
		
		
		return "member/login";
	}
	
	
	
	
	
	//회원목록 불러오기
	@GetMapping("/memberlist")
	public String memberList(Model model) {
		

		List<Member> memberList = memberService.getAll();
		model.addAttribute("memberList", memberList);
		
		return "member/memberlist";
	
	}
}
