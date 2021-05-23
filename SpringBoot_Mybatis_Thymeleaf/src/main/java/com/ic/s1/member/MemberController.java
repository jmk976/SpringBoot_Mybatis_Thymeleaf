package com.ic.s1.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/**")
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("page")
	public String page(MemberVO memberVO, HttpSession session)throws Exception{
//		memberVO = (MemberVO)session.getAttribute("member");
		return "member/memberPage";
	}
	
	@GetMapping("logout")
	public String logout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:/";
	}
	
	@GetMapping("join")  //void로 바꾸면 이게 경로
	public String setJoin(@ModelAttribute MemberVO memberVO) throws Exception{   //model에 집어넣는과 같은 효과 
		return "member/memberJoin"; //templates 밑에서 찾으러 감 
	}
	
	@PostMapping("join")
	public String setJoin(@Valid MemberVO memberVO, Errors errors, MultipartFile avatar)throws Exception{
		if(errors !=null && errors.getErrorCount()>0) {
			return "member/memberJoin";
			
			
	
		}
//		if(memberService.memberError(memberVO))
	   return "redirect:../";
	}
	@GetMapping("login")  //void로 바꾸면 이게 경로
	public String getLogin() throws Exception{
		return "member/memberLogin"; //templates 밑에서 찾으러 감 
	}
	
	@PostMapping("login")
	public String getrLogin(MemberVO memberVO, HttpSession session)throws Exception{
		  //로긴 성공한 객체를session에 넣어라
		memberVO = memberService.getLogin(memberVO);
		
	    if(memberVO !=null) {
	    	session.setAttribute("member", memberVO);
	    }
		//session.setAttribute("member", memberVO);
		
		return "redirect:/";
		
	}

}
