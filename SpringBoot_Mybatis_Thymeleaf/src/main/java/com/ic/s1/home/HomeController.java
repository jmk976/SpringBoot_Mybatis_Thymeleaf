package com.ic.s1.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ic.s1.board.BoardVO;

@Controller
public class HomeController {
	
	/**
	 * 
	 * =============================================
	 *          Thymeleaf Project
	 * =============================================
	 * 
	 **/
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("message", "Thymeleaf Project");
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(1L);
		boardVO.setTitle("title");
		boardVO.setWriter("writer");

		System.out.println(boardVO.toString());
		return "index";
	}

}
