package com.ic.s1.board.notice;

import java.awt.datatransfer.Clipboard;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ic.s1.board.BoardVO;

@Controller
@RequestMapping("/notice/**")
public class NoticeController {
	
	@Autowired
	private NoticeService noticeService;
	
	@ModelAttribute("board")  // 모든 메서드가 실행될때. 이 메서드가 먼저 시행됨. 
	public String getBoard() {
		return "notice";
	}
	
	@GetMapping("list")
	public String getList(Model model)throws Exception {
		List<BoardVO> ar = noticeService.getList();
	    model.addAttribute("list", ar);
		 return "board/list";
	}
	
	@GetMapping("select")
	public ModelAndView getSelect(BoardVO boardVO)throws Exception{
		ModelAndView mv = new ModelAndView();
		boardVO = noticeService.getSelect(boardVO);
		mv.addObject("vo", boardVO);
		mv.setViewName("board/select");
		return mv;
	}

}