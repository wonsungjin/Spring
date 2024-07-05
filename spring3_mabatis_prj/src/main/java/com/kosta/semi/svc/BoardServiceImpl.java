package com.kosta.semi.svc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kosta.semi.mappers.BoardMapper;
import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.ReplyVO;
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	private BoardMapper boardMap;
	
	public int svcBoardInsert(@ModelAttribute BoardVO bvo) {
		int insertRows = boardMap.svcBoardInsert(bvo);
		return insertRows;						//   /board_list
	}
	
	public ArrayList<BoardVO> svcBoardList(){
		return boardMap.svcBoardList();			  
	}
	
	public Map svcBoardDetail(int seq){
		BoardVO bvo =boardMap.svcBoardDetail(seq);
		ArrayList<ReplyVO> rlist = boardMap.svcReplyListForRest(seq);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("my_bvo",   bvo);
		map.put("my_rlist", rlist);
		return  map;
	}
	
	  public int svcBoardDelete(@RequestParam int seq) {
	
	      return boardMap.svcBoardDelete(seq);
	  }
	  public int svcboardUpdate(@ModelAttribute BoardVO bvo) {
	
	      return  boardMap.svcboardUpdate(bvo);
	  }
	

	//댓글목록 : REST
	@ResponseBody 
	public ArrayList<ReplyVO> svcReplyListForRest(@RequestParam("seq") int seq){

		return  boardMap.svcReplyListForRest(seq);
	}
	//댓글목록 : REST
		@ResponseBody 
		public ArrayList<ReplyVO> getReplyBySeq(@RequestParam("seq") int seq){

			return  boardMap.getReplyBySeq(seq);
		}
	
	//댓글등록 : REST
	@ResponseBody 
	public int svcReplyInsertForRest( @ModelAttribute ReplyVO rvo){

		return boardMap.svcReplyInsertForRest(rvo);
	}
	//댓글삭제 : REST
		@ResponseBody 
		public int svcReplyDeleteForRest(@ModelAttribute ReplyVO rvo){

			return  boardMap.svcReplyDeleteForRest(rvo);
		}
	//댓글목록 : REST
	@ResponseBody 
	public ArrayList<BoardVO> svcReplySearchForRest(@RequestParam("search_str") String str){
		return  boardMap.svcReplySearchForRest(str);
	}


	


}
