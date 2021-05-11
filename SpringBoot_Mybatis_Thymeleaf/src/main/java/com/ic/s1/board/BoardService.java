package com.ic.s1.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public interface BoardService {
	
	
	public List<BoardVO> getList()throws Exception;
	
	//public Long getTotalCount()throws Exception;
	
	public BoardVO getSelect(BoardVO boardVO)throws Exception;
	
	public int setInsert(BoardVO boardVO)throws Exception;
	
	public int setUpdate(BoardVO boardVO)throws Exception;
	
	//public int setHitUpdate(BoardVO boardVO)throws Exception;
	
	public int setDelete(BoardVO boardVO)throws Exception;

}
