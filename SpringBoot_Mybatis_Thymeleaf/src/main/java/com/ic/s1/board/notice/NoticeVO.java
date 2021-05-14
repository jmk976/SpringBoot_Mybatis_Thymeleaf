package com.ic.s1.board.notice;

import java.util.List;

import com.ic.s1.board.BoardFileVO;
import com.ic.s1.board.BoardVO;




public class NoticeVO extends BoardVO {
	
	private List<BoardFileVO> files;

	public List<BoardFileVO> getFiles() {
		return files;
	}

	public void setFiles(List<BoardFileVO> files) {
		this.files = files;
	}



}
