package com.qna.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qna.domain.Member;
import com.qna.dto.JoinDto;
import com.qna.service.MemberService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class MemberController {


	    private final MemberService memberService;

	   
	    //회원가입
	    @GetMapping("/join/member")
	    public String joinMember() {
	        return "member/joinmembers";
	    }

	    @PostMapping("/join/member")
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
		@GetMapping("/join/login")
		public String getLogin() {
			return "member/login";
		}
		
		
		@PostMapping("/join/login")
		public String postLogin(HttpServletRequest request, JoinDto joinDto) {
			
	    	HttpSession session = request.getSession();
            Optional<Member> member = memberService.findByEmail(joinDto.getEmail());
            if(member.get().getEmail().equals(joinDto.getEmail()) && member.get().getPassword().equals(joinDto.getPassword())) {
                session.setAttribute("login", "logined");
            	session.setAttribute("member", member);
                session.setAttribute("message", "로그인 성공");
                System.out.println("로그인 성공");
                return "redirect:/";

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

		
		//마이페이지
		
		
		
		
		//회원정보 수정
		
		
		
		//회원탈퇴
		
		
		
//	    @GetMapping("/{itemId}/edit")
//	    public String editForm(@PathVariable Long itemId, Model model) {
//	        Item item = itemService.findById(itemId).get();
//	        model.addAttribute("item", item);
//	        return "editForm";
//	    }
//
//	    @PostMapping("/{itemId}/edit")
//	    public String edit(@PathVariable Long itemId, @ModelAttribute ItemUpdateDto updateParam) {
//	        itemService.update(itemId, updateParam);
//	        return "redirect:/items/{itemId}";
//	    }
}
