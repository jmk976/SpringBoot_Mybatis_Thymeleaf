package com.ic.s1.util;


public class Pager {
	//현재 페이지
	private Long curPage;
	//페이지당 게시물 수
	private Long perPage;
	//해당 페이지의 첫 게시물
	private Long startRow;
	
	//page
	//해당 블락의 첫 페이지 숫자
	private Long startNum;
	//해당 블락의 마지막 페이지 숫자
	private Long lastNum;
	
	//previous버튼 존재 유무
	private boolean pre;
	//next버튼 존재 유무
	private boolean next;
	
	//search
	private String kind;
	private String search;
	

	public void makeNum(Long totalCount) {
		 int perBlock=5;
		//1. totalCount
		
		//2. totalCount를 이용해서 totalPage 수 구하기
		Long totalPage =totalCount/this.getPerPage();
		if(totalCount%this.getPerPage()!=0) {
			totalPage++;
		}
		//3. totalPage를 이용해서 totalBlock 수 구하기
		Long totalBlock = totalPage/perBlock;
		if(totalPage % perBlock != 0) { 
			totalBlock++;
		}
		//4. curPage를 이용해서 curBlock구하기
		Long curBlock = this.getCurPage()/perBlock;
		 if(this.curPage%perBlock != 0) {
			 curBlock ++;
		 }
		//5. curBlock 이용해서 startNum, lastNum 구하기
		 startNum = (curBlock-1)*perBlock+1;
		 lastNum = curBlock*perBlock;
		 
		 //6.curBlock이 마지막 (totalBlock)
		 this.pre = true;
		 this.next = true;
		 if(curBlock == totalBlock) {
		     lastNum = totalPage;
		     this.next = false;
		 }
		 
		 if(curBlock == 1) {
			 this.pre = false;
		 }
	}
	
	public void makeRow() {
		//Spring Boot에선 lastRow 없이 계산 가능
		// curPage   startRow
		//  1          0
		//  2          10
		//  3          20
		
		this.startRow = (this.getCurPage()-1)*this.getPerPage();
	}

	public Long getCurPage() {
		if(this.curPage == null || this.curPage ==0) {
			this.curPage=1L;
		}
		return curPage;
	}

	public void setCurPage(Long curPage) {
		if(curPage == null || curPage ==0) {
			this.curPage=1L;
		} else {
			this.curPage = curPage;
		}
		this.curPage = curPage;
	}

	public Long getPerPage() {
		if(this.perPage == null || this.perPage ==0) {
			this.perPage=10L;
		}
		return perPage;
	}

	public void setPerPage(Long perPage) {
		if(perPage == null || perPage ==0) {
			this.perPage=10L;
		} else {
			this.perPage = perPage;
		}
		this.perPage = perPage;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public boolean isPre() {
		return pre;
	}

	public void setPre(boolean pre) {
		this.pre = pre;
	}

	public boolean isNext() {
		return next;
	}

	public void setNext(boolean next) {
		this.next = next;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search==null) {
			this.search="";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
}
