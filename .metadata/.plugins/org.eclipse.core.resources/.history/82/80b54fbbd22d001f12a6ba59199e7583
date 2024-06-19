package com.lec05.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.lec05.board.BoardDAO;
import com.lec05.board.BoardVO;

@Controller
@RequestMapping("/board2")
public class BoardRestController {

	@Autowired
	private BoardDAO dao;
	
	@RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String boardListOne(@RequestParam int seq, Model model) {
       BoardVO vo = dao.boardReplySelect(seq);  
        model.addAttribute("KEY_BOARDVO", vo);
        return "lec05_rest/board_detail";
    }
	
}
