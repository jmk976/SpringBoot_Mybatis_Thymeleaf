package com.ic.s1.member;

import java.util.Enumeration;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
		
		return "redirect:../";
	}
	
	@GetMapping("join")  //void로 바꾸면 이게 경로
	public String setJoin(@ModelAttribute MemberVO memberVO) throws Exception{   //model에 집어넣는과 같은 효과 
		return "member/memberJoin"; //templates 밑에서 찾으러 감 
	}
	
	@PostMapping("join")
	public String setJoin(@Valid MemberVO memberVO, Errors errors, MultipartFile avatar)throws Exception{
		System.out.println("Join Process" + memberVO.getName().length());
		//		if(errors !=null && errors.getErrorCount()>0) {
			
		if(memberService.memberError(memberVO, errors)) {
			return "member/memberJoin";
		}
		
		
		 int result = memberService.setJoin(memberVO, avatar);

	   return "redirect:../";
	}
	
	
	@GetMapping("login")  //void로 바꾸면 이게 경로
	public String getLogin() throws Exception{
		return "member/memberLogin"; //templates 밑에서 찾으러 감 
	}
	
	@GetMapping("loginFail")
	public String loginFail(Model model) throws Exception{
		System.out.println("Login Fail");
		//model.addAttribute(getLogin(), model);  따로 핸들링 하고 싶으면.. 
		return "redirect:/member/login";
	}
	
	@GetMapping("memberLoginResult")     // 로그인 폼에서 서비스로 보내 로그인 처리해야하는데 이제secutiry 가 알아서 처리
	public String memberLoginResult (HttpSession session) throws Exception {
		
		//session의 속성명들 꺼내오기
		Enumeration<String> en = session.getAttributeNames();
		
		while(en.hasMoreElements()) {
			System.out.println("Attribute Name: "+en.nextElement());
		}
		
		//로그인 시 session의 속성명 :  SPRING_SECURITY_CONTEXT
		
	    Object obj = session.getAttribute("SPRING_SECURITY_CONTEXT");
   
	   System.out.println(obj); // 출력: SecurityContextImpl [Authentication=UsernamePasswordAuthenticationToken [Principal=MemberVO(username=id5, password1=null, password=$2a$10$LrSoOIzV436lfHCF2sORVeVJ9kqAsc0LxD5kQQvFbEspGI4H8beDq, name=id5, email=id5@naver.com, phone=0105555555, enabled=true, roles=[RoleVO(id=2, roleName=ROLE_MEMBER)]), Credentials=[PROTECTED], Authenticated=true, Details=WebAuthenticationDetails [RemoteIpAddress=0:0:0:0:0:0:0:1, SessionId=248E670B6C3BAB24BE5129029DD7A672], Granted Authorities=[ROLE_MEMBER]]]
	    
	   
	    SecurityContextImpl sc = (SecurityContextImpl)obj;
	    
	   Authentication auth = sc.getAuthentication();
	   
	   System.out.println("===================================");
	   System.out.println("name: "+auth.getName());
	   System.out.println("details: "+auth.getDetails());
	   System.out.println("principal: "+auth.getPrincipal());
	   System.out.println("authorities: "+auth.getAuthorities());
	   System.out.println("===================================");
 
	    
		System.out.println("Login 성공");
		return "redirect:/";  // 로그인 성공 을 session객체에 받아 놓는다 
	}
	
//	@PostMapping("login")
//	public String getrLogin(MemberVO memberVO, HttpSession session)throws Exception{
//		  //로긴 성공한 객체를session에 넣어라
//		memberVO = memberService.getLogin(memberVO);
//		
//	    if(memberVO !=null) {
//	    	session.setAttribute("member", memberVO);
//	    }
//		//session.setAttribute("member", memberVO);
//		
//		return "redirect:/";
//		
//	}

}
