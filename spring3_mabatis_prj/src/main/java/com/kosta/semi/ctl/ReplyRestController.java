package com.kosta.semi.ctl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kosta.semi.svc.BoardService;
import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.ReplyVO;

@RestController
public class ReplyRestController {   

    @Autowired
    private BoardService boardService;
    
    


        @RequestMapping(value = "/reply_list_rest", produces = "application/json")
        public ResponseEntity<ArrayList<ReplyVO>> ctlReplyListForRest(@RequestParam("seq") int seq) {
            System.out.println("요청된 seq 값: " + seq);

            ArrayList<ReplyVO> rlist = boardService.getReplyBySeq(seq);

            if(rlist==null) new ResponseEntity<>(HttpStatus.OK);
            return new ResponseEntity<>(rlist, HttpStatus.OK);
        }
    

	// 댓글등록 : REST
	@RequestMapping(value = "/reply_insert_rest", method = RequestMethod.POST)
	public int ctlReplyInsertForRest( @ModelAttribute ReplyVO rvo) {

		return boardService.svcReplyInsertForRest(rvo);
	}

	// 댓글삭제 : REST
	@RequestMapping(value = "/reply_delete_rest", method = RequestMethod.POST)
	public int ctlReplyDeleteForRest( @ModelAttribute ReplyVO rvo) {

		return boardService.svcReplyDeleteForRest(rvo);
	}

	// 댓글목록 : REST
	@RequestMapping(value = "/board_search", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ArrayList<BoardVO>> ctlReplyListForRest( @RequestParam("search_str") String str) {
		System.out.println(str);

		ArrayList<BoardVO> rlist = boardService.svcReplySearchForRest(str);
		return new ResponseEntity<>(rlist, HttpStatus.OK);
	}
  
}