package com.ic.s1.board.qna;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/qna/**")
public class QnaController {
	
	@ModelAttribute("board")  // 모든 메서드가 실행될때. 이 메서드가 먼저 시행됨. 
	public String getBoard() {
		return "qna";
	}
	
	@GetMapping("list")
	public String getList()throws Exception{
	    // model.addAttribute("board", "qna"); <-이거를 위의메소드로 대체;
		return "board/list";
		
	}

}
