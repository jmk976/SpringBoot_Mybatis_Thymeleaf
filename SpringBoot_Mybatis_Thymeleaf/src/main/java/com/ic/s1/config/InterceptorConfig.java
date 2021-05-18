package com.ic.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ic.s1.Interceptor.TestInterceptor;

//@Configuration  //xml root-context, servlet-context 와 같다는 뜻./주석 처리 하면 실행안됨.
public class InterceptorConfig implements WebMvcConfigurer{  //웹만드는데 최적
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {  // Interceptors 를 추가
	    //적용할 Interceptor bean을 등록
		 registry.addInterceptor(testInterceptor)
		 //add  -> Interceptor를 적용할 URL 등록 
		 // .addPathPatterns("/notice/**")  //notice로 시작하는 모든 애들은 이 인터셉트를 거쳐라
		 .addPathPatterns("/qna/**"); //중복해서 추가 가능.
		 //exclude -> Interceptor에서 제외할 URL 등록.
		//.excludePathPatterns("/notice/select");  //이 루트는 빼주세요. ; <-종료의 의미 
		//다시 registry.addInterceptor(testInterceptor) 추가해서 사용하거나 아니면 interceptor파일 여러개 만들기.
		 
		//Interceptor bean을 등록
	    //어떤 URL 설정
		 
		//WebMvcConfigurer.super.addInterceptors(registry);  오버라이딩 되는 문장. 필요없음.
	 
	 }
	
	

}
