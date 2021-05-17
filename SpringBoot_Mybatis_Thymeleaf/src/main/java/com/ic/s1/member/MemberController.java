package com.ic.s1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")  //void로 바꾸면 이게 경로
	public String memberJoin() throws Exception{
		return "member/memberJoin"; //templates 밑에서 찾으러 감 
	}
	
	@GetMapping("login")  //void로 바꾸면 이게 경로
	public String memberLogin() throws Exception{
		return "member/memberLogin"; //templates 밑에서 찾으러 감 
	}
	
	@PostMapping("login")
	public String memberLogin(MemberVO memberVO, HttpSession session)throws Exception{
		
		memberVO = memberService.memberLogin(memberVO);
		session.setAttribute("member", memberVO);
		
		return "redirect:../";
		
	}

}
