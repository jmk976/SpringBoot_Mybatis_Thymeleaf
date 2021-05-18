package com.ic.s1.Interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ic.s1.member.MemberVO;

@Component
public class AdminInterceptor implements HandlerInterceptor {

	// controller 진입전 admin판별
	// admin이면 진행
	// admin 아니라면 
	//1. 로그인폼으로 리다이렉트
	//2. 권한이 없음 alert, index로 이동
	
	// /notice/insert, update, delete
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//page         :-----
		//request      :----------
		//session      :---------------
		//application  :--------------------
		
	    System.out.println("preHandle시작");
		HttpSession session = request.getSession();
		MemberVO memberVO = (MemberVO)session.getAttribute("member");
		System.out.println(memberVO);
		System.out.println("preHandle종료");
		
		boolean result =false;
        if(memberVO != null && memberVO.getUsername().equals("admin")) {
				result=true;
			} else {
				//1. redirect login 
				response.sendRedirect("/member/login");
				
				//2.forward
		/*		request.setAttribute("msg", "관리자가 아님");
			    request.setAttribute("path", "/member/login");
				RequestDispatcher view = request.getRequestDispatcher("classpath:/common/result.html");
				view.forward(request, response);  */
			}
        

		return result;
	}
}
