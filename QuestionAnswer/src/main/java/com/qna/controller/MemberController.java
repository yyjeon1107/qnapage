package com.qna.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qna.domain.Member;
import com.qna.dto.JoinDto;
import com.qna.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {


	    private final MemberService memberService;

	   
	    //회원가입
	    @GetMapping("/join")
	    public String joinMember() {
	        return "member/joinmembers";
	    }

	    @PostMapping("/join")
	    public String joinMember(HttpServletRequest request, @ModelAttribute Member member) {
	        
	    	HttpSession session = request.getSession();
	    	
	    	Member joinedMember = memberService.join(member);
	    	if(joinedMember != null) {
	    		session.setAttribute("message", "회원가입 성공");
	    		return "redirect:/";
	    	}else {
	    		session.setAttribute("message", "회원가입 실패");
				return "redirect:/member/joinmembers";

	    	}
	    
	    }
	    
	    
	    //로그인
		@GetMapping("/login")
		public String getLogin() {
			return "member/login";
		}
		
		
		@PostMapping("/login")
		public String postLogin(HttpServletRequest request, JoinDto joinDto) {
					
			HttpSession session = request.getSession();
            Member member = memberService.findByEmail(joinDto.getEmail());
            if(member.getEmail().equals(joinDto.getEmail()) && member.getPassword().equals(joinDto.getPassword())) {
                session.setAttribute("login", "logined");
            	session.setAttribute("member", member);
                session.setAttribute("message", "로그인 성공");
                System.out.println("로그인 성공");
                System.out.println(member.getRole());
                return "/member/result";

            }else {
                System.out.println("로그인 실패");
            	return "redirect:/member/login";
            }
		}
		
		
		
		//로그아웃
		@GetMapping("/logout")
		public String logout(HttpServletRequest request) {
	        HttpSession session = request.getSession();
	        session.setAttribute("login", null); 
	        session.setAttribute("member", null);
	        session.setAttribute("message", "로그아웃");        
			return "redirect:/";
		}

		
		//마이페이지(고객 로그인)
		@GetMapping("/mypage/{email}")
		public String myPage(@PathVariable String email, Model model) {
			
			Member member = memberService.findByEmail(email);
			model.addAttribute("member", member);
			
						
			return "/member/mypage";
		}
		
		
		
		//회원정보 수정
//	    @GetMapping("/{id}/edit")
//	    public String getMemberUpdate(@PathVariable int id, Model model) {
//	        Member member = memberService.findById(id).get();
//	        model.addAttribute("member", member);
//	        return "editForm";
//	    }
//
//	    @PostMapping("/{id}/edit")
//	    public String postMemberUpdate(@PathVariable int id, @ModelAttribute MemberUpdateDto updateParam) {
//	        itemService.update(itemId, updateParam);
//	        return "redirect:/items/{itemId}";
//	    }
		
		
		
		//회원리스트보기(관리자 로그인)
		@GetMapping("/memberlist")
		public String adminMemberList(Model model) {
			
			List<Member> memberList = memberService.findAll();
			model.addAttribute("memberList", memberList);
			return "/member/memberlist";
		}
		
		
		//회원탈퇴
		
		
		

}
