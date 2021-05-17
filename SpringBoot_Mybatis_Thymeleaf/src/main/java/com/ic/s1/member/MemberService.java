package com.ic.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
	public MemberVO memberLogin(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.memberLogin(memberVO);
		return memberVO;
	}
	
	public MemberVO memberLogout(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.memberLogout(memberVO);
		return memberVO;
	}
	
	public MemberVO memberJoin(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.memberJoin(memberVO);
		return memberVO;
	}
	
	public MemberVO memberPage(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.memberPage(memberVO);
		return memberVO;
	}
	
	
	

}
