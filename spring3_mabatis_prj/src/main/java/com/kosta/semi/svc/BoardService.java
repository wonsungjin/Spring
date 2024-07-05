package com.kosta.semi.svc;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.semi.vo.BoardVO;
import com.kosta.semi.vo.ReplyVO;

public interface BoardService {
    
    // 게시물 삽입
    int svcBoardInsert(@ModelAttribute BoardVO bvo);
    ArrayList<ReplyVO> getReplyBySeq(int seq);
    // 게시물 목록 조회
    ArrayList<BoardVO> svcBoardList();

    // 게시물 상세 조회
    Map svcBoardDetail(@RequestParam("seq") int seq);

    // 게시물 삭제
    int svcBoardDelete(@RequestParam("seq") int seq);
    int svcboardUpdate(@ModelAttribute BoardVO bvo);

    // 댓글 목록 조회 (REST)
    ArrayList<ReplyVO> svcReplyListForRest(@RequestParam("seq") int seq);

    // 댓글 등록 (REST)
    int svcReplyInsertForRest(@ModelAttribute ReplyVO rvo);

    // 댓글 삭제 (REST)
    int svcReplyDeleteForRest(@ModelAttribute ReplyVO rvo);

    // 검색을 통한 댓글 목록 조회 (REST)
    ArrayList<BoardVO> svcReplySearchForRest(@RequestParam("search_str") String str);
}
