package com.ic.s1.member;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class MemberVO {
	
	private String username;
	@Length(max=10, min=2)
	private String password;
	@NotEmpty
	private String name;
	private String email;
	private String phone;

}
