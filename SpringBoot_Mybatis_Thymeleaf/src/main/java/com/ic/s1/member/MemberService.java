package com.ic.s1.member;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import com.ic.s1.board.BoardFileVO;
import com.ic.s1.util.FileManager;



@Service
//Spring Security에서 사용하는 service
//UserDetailsService구현
public class MemberService implements UserDetailsService {
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
    private FileManager fileManager;
	@Autowired
    private PasswordEncoder passwordEncoder;  // 비번을 암호화 

	
     
	//login 메서드
	//개발자가 호출 X, Spring이 해준
		@Override
		public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			MemberVO memberVO = new MemberVO();
			memberVO.setUsername(username);
			memberVO = memberMapper.getLogin(memberVO);
			return memberVO;  //아이디와 비번 둘다 가지고 있고 security가 알아서 처리 
		}
   
		//검증 메서드
		public boolean memberError(MemberVO memberVO, Errors errors)throws Exception{
			boolean result = false;
			
			//기본 제공 검증  결과
//			if(errors.hasErrors()) {
//				result = true;
//			}
			result = errors.hasErrors();
			
			//password가 일치 여부 검증
			if(!memberVO.getPassword().equals(memberVO.getPassword1())) {
				errors.rejectValue("password1", "memberVO.password.notEqual");
							     //(form path, field 명, properties의 code(key));
				result=true;
			}
			
			//UserName 중복 여부
			MemberVO checkMember = memberMapper.getUsername(memberVO);
			//checkMember 가 null이면 중복 X
			//checkMember 가 null이 아니면 중복
			if(checkMember != null) {
				errors.rejectValue("username", "member.id.equal");
				result = true;
			}
			
			//admin, adminstrator, root
			
			System.out.println("Validate : "+result);
			return result;
		}
	
	 public MemberVO memberLogout(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.memberLogout(memberVO);
		return memberVO;
	}
	
	 @Transactional(rollbackFor = Exception.class)
	public int setJoin(MemberVO memberVO, MultipartFile multipartFile)throws Exception{
		//0. 사전작업
		
	     //a. password 암호화
		memberVO.setPassword(passwordEncoder.encode(memberVO.getPassword()));
		//b. 사용자 계정 활성화 
		memberVO.setEnabled(true);
		

		//1. Member Table에 저장
		int result = memberMapper.setJoin(memberVO);
		
		//2.Role Table 저장
		Map<String, String> map = new HashMap<String, String>();
		map.put("username", memberVO.getUsername());
		map.put("roleName", "role_member");
		result = memberMapper.setMemberRole(map);
		//2. HDD에 저장 
		 String filePath="upload/member/"; // 자바 개발자가 필
		 if(multipartFile.getSize()==0) {
			 String fileName = fileManager.save(multipartFile, filePath);
			 System.out.println(fileName);
			 MemberFileVO memberFileVO = new MemberFileVO();
			 memberFileVO.setFileName(fileName);
			 memberFileVO.setOriName(multipartFile.getOriginalFilename());
			 memberFileVO.setUsername(memberVO.getUsername());
		 //3. MemberFiles table에 저장
			result = memberMapper.setJoinFile(memberFileVO);
			}
	
		
		return result;
	}
	
	public MemberVO memberPage(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.memberPage(memberVO);
		return memberVO;
	}
	
	
	

}
