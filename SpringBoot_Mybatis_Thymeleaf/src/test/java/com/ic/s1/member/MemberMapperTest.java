package com.ic.s1.member;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;

import javax.print.attribute.HashAttributeSet;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberMapperTest {
	
	@Autowired
	private MemberMapper memberMapper;
	
	@Test
	void getMemberLoginTest()throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("id3");
		 
		memberVO = memberMapper.getLogin(memberVO);
		
		for(RoleVO roleVO : memberVO.getRoles()) {
			System.out.println(roleVO.getRoleName());
		}
		assertNotNull(memberVO);
	}
	
	
	//@Test
	void setMemberRoleTest() throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", "id3");
		map.put("roleName", "MEMBER");
		int result = memberMapper.setMemberRole(map);
		assertEquals(1, result);
	}

	//@Test
	void test() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setUsername("id2");
		memberVO.setPassword("id2");
		memberVO.setName("id2");
		memberVO.setPhone("0102222222");
		memberVO.setEmail("id2@vaer.com");
		memberVO.setEnabled(true);
		int result = memberMapper.setJoin(memberVO);
		assertEquals(1, result);
	}

}
