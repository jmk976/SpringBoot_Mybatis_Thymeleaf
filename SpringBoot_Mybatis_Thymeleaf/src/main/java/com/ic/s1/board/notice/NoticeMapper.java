package com.ic.s1.board.notice;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.ic.s1.board.BoardMapper;

//@Repository
@Mapper     
public interface NoticeMapper extends BoardMapper {

	// 오버라이딩 안해서 알아서찾아감. getList() 
}
