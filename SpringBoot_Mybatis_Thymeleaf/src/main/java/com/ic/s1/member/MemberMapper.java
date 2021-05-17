package com.ic.s1.member;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MemberMapper {
	
	public MemberVO getLogin (MemberVO memberVO)throws Exception;
	
	public int setJoin (MemberVO memberVO)throws Exception;
	
	public int setJoinFile(MemberFileVO memberFileVO)throws Exception;
	
	public MemberVO memberLogout (MemberVO memeberVO)throws Exception;
	
	public MemberVO memberPage (MemberVO memeberVO)throws Exception;

}
