package com.ic.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.web.multipart.MultipartFile;

import com.ic.s1.board.BoardFileVO;
import com.ic.s1.util.FileManager;



@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
     private FileManager fileManager;
     
     //검증 메서드 
     public boolean memberError(MemberVO memberVO,Errors errors) throws Exception{
    	 boolean result = false;
    	 
    	 //r기본 제공 검증 결
//    	 if(errors.hasErrors()) {
//    		 result=true;
//    	 }
    	 
    	 result=errors.hasErrors();
    	 
    	 //password가 일치 여부검증
    	if(!memberVO.getPassword().equals(memberVO.getPassword())) {
    		errors.rejectValue("password1", "memberVO.password.notEqual");
    		                  //(form path, field명, properties의 code(key));
    		result=true;
    	}
    	//UserName  중복여
        // MemberVO checkMember = memberMapper.getUsername
        //checkMeber 가 null이 아니면 중복
        		 
//        if(checkMember != null) {
//        	errors.rejectValue("username", "member.id.equal");
//        	result = true;
//        }
        		
    	 
    	 return result;
     }
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.getLogin(memberVO);
		return memberVO;
	}
	
	public MemberVO memberLogout(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.memberLogout(memberVO);
		return memberVO;
	}
	
	public int setJoin(MemberVO memberVO, MultipartFile multipartFile)throws Exception{
		//1. Member Table에 저장
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
			 memberMapper.setJoinFile(memberFileVO);
			}
	
		int result = memberMapper.setJoin(memberVO);
		return result;
	}
	
	public MemberVO memberPage(MemberVO memberVO)throws Exception{
		memberVO = memberMapper.memberPage(memberVO);
		return memberVO;
	}
	
	
	

}
