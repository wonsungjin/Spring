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
		ArrayList<BoardVO> list = boardMap.svcBoardList();
		return list;     				  
	}
	
	public Map svcBoardDetail(int seq){
		//------------------------------------------------------
		//상세,댓글목록 각각 사용할 경우
		//	트랜잭션 : SELECT(게시물상세) , SELECT(댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} () 
		//	댓글목록 EL  : ${KEY_REPLYLIST}
		//------------------------------------------------------
		BoardVO bvo              = boardMap.svcBoardDetail(seq);
		ArrayList<ReplyVO> rlist = boardMap.svcReplyListForRest(seq);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("my_bvo",   bvo);
		map.put("my_rlist", rlist);
		
		//------------------------------------------------------
		//조인을 사용할 경우
		//	트랜잭션 : SELECT JOIN(게시물상세 + 댓글목록) 
		//	게시물상세 EL : ${KEY_BOARDVO} 
		//	댓글목록 EL  : ${KEY_BOARDVO.replies}
		//------------------------------------------------------
//		BoardVO bvo = boardMap.boardReplySelect(seq);
		return map;	
	}
	
	  public int svcBoardDelete(@RequestParam int seq) {
		  int insertRows = boardMap.svcBoardDelete(seq);
	      return insertRows;
	  }
	  public int svcboardUpdate(@ModelAttribute BoardVO bvo) {
		  int insertRows = boardMap.svcboardUpdate(bvo);
	      return insertRows;
	  }
	

	//댓글목록 : REST
	@ResponseBody 
	public ArrayList<ReplyVO> svcReplyListForRest(@RequestParam("seq") int seq){
		System.out.println(seq);
		
		ArrayList<ReplyVO> rlist = boardMap.svcReplyListForRest(seq);
		return rlist;	
	}
	
	//댓글등록 : REST
	@ResponseBody 
	public String svcReplyInsertForRest( @ModelAttribute ReplyVO rvo){
		System.out.println("입력 "+rvo.getReply());
		
		int res = boardMap.svcReplyInsertForRest(rvo);
		String msg = "입력에러";
		if(res > 0) {
			msg = "입력성공";
		}
		//return String.valueOf(res);	
		return String.valueOf(msg);
	}
	//댓글삭제 : REST
		@ResponseBody 
		public String svcReplyDeleteForRest(@ModelAttribute ReplyVO rvo){
			System.out.println("삭제 "+rvo.getRseq());
			
			int res = boardMap.svcReplyDeleteForRest(rvo);
			String msg = "입력에러";
			if(res > 0) {
				msg = "입력성공";
			}
			//return String.valueOf(res);	
			return String.valueOf(msg);
		}
	//댓글목록 : REST
	@ResponseBody 
	public ArrayList<BoardVO> svcReplySearchForRest(@RequestParam("search_str") String str){
		System.out.println(str);
		
		ArrayList<BoardVO> rlist = boardMap.svcReplySearchForRest(str);
		return rlist;	
	}


	


}
