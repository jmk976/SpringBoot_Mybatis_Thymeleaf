package com.ic.s1.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ic.s1.Interceptor.TestInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{
	
	@Autowired
	private TestInterceptor testInterceptor;
	
	 @Override
	public void addInterceptors(InterceptorRegistry registry) {
	    //적용할 Interceptor bean을 등록
		 registry.addInterceptor(testInterceptor)
		 .addPathPatterns("/notice/**");
		//Interceptor bean을 등록
	    //어떤 URL 설정
		WebMvcConfigurer.super.addInterceptors(registry);
	 
	 }
	
	

}
