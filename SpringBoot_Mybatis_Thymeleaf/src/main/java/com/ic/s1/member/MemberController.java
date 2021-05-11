package com.ic.s1.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@GetMapping("join")  //void로 바꾸면 이게 경로
	public String setJoin() throws Exception{
		return "member/memberJoin"; //templates 밑에서 찾으러 감 
	}
	
	@GetMapping("login")  //void로 바꾸면 이게 경로
	public String getLogin() throws Exception{
		return "member/memberLogin"; //templates 밑에서 찾으러 감 
	}

}
