package com.ic.s1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception;
	
	public MemberVO memberJoin(MemberVO memberVO)throws Exception;

}