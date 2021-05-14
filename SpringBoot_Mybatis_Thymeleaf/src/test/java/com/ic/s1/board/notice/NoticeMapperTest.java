package com.ic.s1.board.notice;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.ic.s1.board.BoardVO;
import com.ic.s1.util.Pager;

@SpringBootTest
class NoticeMapperTest {
	
	@Autowired
	private NoticeMapper noticeMapper;
	
	@Test
	void setInsertTest() throws Exception{
		
		for(int i=0; i<100; i++) {
			 BoardVO boardVO = new BoardVO();
			 boardVO.setTitle("title"+i);
			 boardVO.setContents("contents"+i);
			 boardVO.setWriter("writer"+i);
			 noticeMapper.setInsert(boardVO);
			 Thread.sleep(100);
		}
		System.out.println("finish");
	}

	@Test
	void getListTest(Pager pager)throws Exception{
		
		List<BoardVO> ar = noticeMapper.getList(pager);
		
		for(BoardVO boardVO:ar) {
			System.out.println(boardVO.toString());
		}
		
		
		assertNotEquals(0, ar.size());
	}

}
