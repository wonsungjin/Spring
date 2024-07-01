package com.kosta.semi.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kosta.semi.jpa.entity.BoardEntity;
import com.kosta.semi.jpa.service.BoardService;

@Controller
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	
	
	@RequestMapping(value="/board_list")
	//http://localhost:8089/jpa_list
	public String ctlBoardList(ModelMap model) {
		List<BoardEntity> list = boardService.svcBoardList();
		model.addAttribute("MY_LIST", list);
		System.out.println(list.toString());
		return "hello";
	}
	
	
	//http://localhost:8089/jpa_detail?BoardSeq=1
	//@RequestMapping(value="/jpa_detail")
	//public String ctlBoardDetail(ModelMap model, @RequestParam("BoardSeq") int BoardSeq) {
		
	//http://localhost:8089/jpa_detail/1
	@RequestMapping(value="/board_detail/{aaa}")
	public String ctlBoardDetail(ModelMap model, @PathVariable("aaa") Long BoardSeq) {
		BoardEntity entity = boardService.svcBoardDetail(BoardSeq);
		model.addAttribute("MY_ENTITY", entity);
		System.out.println(entity.toString());
		return "hello";
	}

	//http://localhost:8089/jpa_update
	@RequestMapping(value="/board_update")
	public String ctlBoardUpdate(ModelMap model, @ModelAttribute BoardEntity BoardEntity) {
		//update Boards3 set Board_pw=#{BoardPw} where Board_id=#{BoardId}
//		BoardEntity.setId(1L);
//		BoardEntity.setBoardId("admin");
//		BoardEntity.setBoardPw("444");
		boardService.svcBoardUpdate(BoardEntity);
		return "hello";
	}

	//http://localhost:8089/jpa_delete/1
	@RequestMapping(value="/board_delete/{aaa}")
	public String ctlBoardDelete(ModelMap model, @PathVariable("aaa") Long BoardSeq) {
		//delete from Boards3 where Board_seq=#{BoardSeq}
		boardService.svcBoardDelete(BoardSeq);
		return "hello";
	}
	
}
