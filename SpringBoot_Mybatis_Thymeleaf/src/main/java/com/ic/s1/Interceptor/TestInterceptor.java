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

import com.ic.s1.member.MemberVO;

@Component
public class TestInterceptor implements HandlerInterceptor{
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//Controller 진입전에
		System.out.println("controller진입전");
//		HttpSession session = request.getSession();
//		Object obj = session.getAttribute("member");
//		MemberVO memberVO = null;
//		boolean result= false;
//		if(obj != null) {
//			memberVO = (MemberVO)obj;
//			if(memberVO.getUsername().equals("admin")) {
//				result = true;
//			}
//		}
//		
//		if(!result) {
//			response.sendRedirect("/member/login");
//		}
//		
//		request.setAttribute("name", "data");
//		RequestDispatcher view = request.getRequestDispatcher("view경로");
//		view.forward(request, response);

		return true;
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//Controller 종료후 실행
	     System.out.println("Controller 종료후");
	     Map<String, Object> map = modelAndView.getModel();
	     Iterator<String> it = map.keySet().iterator(); //키들을 열거형으로 바꿔줌.
	     
	     while(it.hasNext()) {
	    	 String key = it.next();
	    	 System.out.println(key);
	    	 System.out.println(map.get(key));
	    	 
	     }
	     
	     //view경로를 확인하거나 변경가능
	     //modelAndView.getViewName();
	     //modelAndView.setViewName("");
	}
	
   @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
		throws Exception {
	   // Client  전송 전
	  System.out.println("Client 전송 전");
   }

}
