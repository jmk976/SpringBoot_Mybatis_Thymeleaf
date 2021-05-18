package com.ic.s1.Interceptor;

import java.util.Iterator;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ic.s1.board.BoardVO;
import com.ic.s1.member.MemberVO;

@Component
public class WriterInterceptor implements HandlerInterceptor {
	//controller 종료후
	//작성자, 로그인 유저네임 출력
	
	//WriterInterceptorConfig
	//  /qna/update
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		  //0. Method 형식
	       String method = request.getMethod();
	       
	       if(method.equals("GET")) {
	    	   this.check(request, modelAndView);
	       }
		 
		  //HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}
	private void check(HttpServletRequest request,
			ModelAndView modelAndView) {
		 //1. 로그인
		  HttpSession session = request.getSession();
		  MemberVO memberVO = (MemberVO)session.getAttribute("member");
	//	  System.out.println("Username:"+ memberVO.getUsername());
		  
		  //2.작성자
		  BoardVO boardVO = (BoardVO)modelAndView.getModel().get("vo");
		//  System.out.println("Writer:"+ boardVO.getWriter());
		  
		  //3. 유저와 작성자가 일치 하지 않으면
		  // common/result로 이동
		  // 경고창 : 작성자가 아님, list로 이동
		 
		  
		  //4.로그인을 하지 않았으면
		  // common/result로 이동
		  // 경고창 : 로그인 필요, 로그인으로 이동
		  
		  if(memberVO != null && boardVO != null){
			  if(!memberVO.getUsername().equals(boardVO.getWriter())) {
				  modelAndView.setViewName("common/result");
				  modelAndView.addObject("msg", "작성자가 아님");
				  modelAndView.addObject("path", "./list");
						 
			  }
			 
		  }else {
			  modelAndView.setViewName("common/result");
			  modelAndView.addObject("msg", "로그인 필요");
			  modelAndView.addObject("path", "../member/login");
		  }
		  
		 
		  
		  
	}

}
