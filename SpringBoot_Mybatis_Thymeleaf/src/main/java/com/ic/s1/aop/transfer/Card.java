package com.ic.s1.aop.transfer;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Card {
	
	@Around("execution(* com.ic.s1.aop.transfer.Transfer.*())")
	public Object cardCheck(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("-----탑승전 card check------");
		//joinPoing - 핵심메서드(버스, 지하철)를 객체화 
	     Object obj = joinPoint.proceed();  //return 값 가져옴..
	     System.out.println(obj);
		System.out.println("-----하차시 card check------");
		
		
		return obj;
	}
	
    @AfterReturning("execution(* com.ic.s1.board.notice.NoticeService.get*(..))")
	public void selectCheck() {
		System.out.println("select Query ended");
	}
}
