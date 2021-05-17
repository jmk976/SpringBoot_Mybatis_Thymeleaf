package com.ic.s1.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ic.s1.board.BoardFileVO;
import com.ic.s1.util.FileManager;



@Service
public class MemberService {
	
	@Autowired
	private MemberMapper memberMapper;
	
     private FileManager fileManager;
	
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
		 String filePath="upload/member/";
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
