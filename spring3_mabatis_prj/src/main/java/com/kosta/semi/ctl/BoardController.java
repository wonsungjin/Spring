package com.kosta.semi.ctl;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.semi.svc.BoardService;
import com.kosta.semi.vo.BoardVO;

@Controller
public class BoardController {   

    @Autowired
    private BoardService boardService;
    
    @RequestMapping(value = "board_insert", method = RequestMethod.POST)
    public String boardInsert(@ModelAttribute BoardVO bvo, Model model) {
    	int insertRows = boardService.svcBoardInsert(bvo);
    	return "redirect:/board_list"; 
    }

    @RequestMapping(value = "board_list", method = RequestMethod.GET)
    public String boardList(Model model) {
        ArrayList<BoardVO> list = boardService.svcBoardList();
        model.addAttribute("KEY_BOARDLIST", list);
        return "board/board_list";
    }
    
    @RequestMapping(value = "board_detail", method = RequestMethod.GET)
    public String boardListOne(@RequestParam int seq, Model model) {
    	
    	Map vo = boardService.svcBoardDetail(seq);  
    	System.out.println(vo);
        model.addAttribute("KEY_BOARDMAP", vo);
        return "board/board_detail";
    }
    
    @RequestMapping(value = "board_delete")
    public String boardDelete(@RequestParam int seq,Model model) {
    	boardService.svcBoardDelete(seq);
        return "redirect:/board_list";
    }
    @RequestMapping(value = "board_update")
    public String boardUpdate(@ModelAttribute BoardVO bvo,Model model) {
    	boardService.svcboardUpdate(bvo);
        return "redirect:/board_list";
    }
  
}