package com.ic.s1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
        //Security를 무시하는 경로 설정
		web.ignoring()
		   .antMatchers("/images/**")
		   .antMatchers("/css/**")
		   .antMatchers("/js/**")
		   .antMatchers("/vendor/**")
		   .antMatchers("/favicon/**")
		   ;

	} 
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//url에 따른 로그인, 권한 설
		http
				.cors().and()
				.csrf().disable()
				.authorizeRequests()
					.antMatchers("/").permitAll()
					.antMatchers("/notice/list", "/notice/select").permitAll()
					.antMatchers("/notice/**").hasRole("ADMIN")
					.antMatchers("/qna/list").permitAll()
					.antMatchers("/qna/**").hasRole("MEMBER")
					.anyRequest().authenticated()
					.and()
					.formLogin()
					.loginPage("/member/login")
					.permitAll()
					;
			 
	}
	

}
