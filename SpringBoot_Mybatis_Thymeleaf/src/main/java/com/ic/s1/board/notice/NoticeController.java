package com.ic.s1.board.notice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@ModelAttribute("board")  // 모든 메서드가 실행될때. 이 메서드가 먼저 시행됨. 
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("list")
	public String getList()throws Exception {
		 return "board/list";
	}

}