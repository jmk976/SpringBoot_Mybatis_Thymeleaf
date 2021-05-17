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
	
	
	

}
