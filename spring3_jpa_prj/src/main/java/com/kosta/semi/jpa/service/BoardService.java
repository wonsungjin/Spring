package com.kosta.semi.jpa.service;

import java.util.List;

import com.kosta.semi.jpa.entity.BoardEntity;
import com.kosta.semi.jpa.entity.ReplyEntity;

public interface BoardService {
	
//	public BoardEntity svcBoardReplySelect(int seq);
	public List<BoardEntity> svcBoardSelect();
	public void svcBoardInsert(BoardEntity bvo);
	public BoardEntity svcBoardSelectOne(Long seq);
	public List<ReplyEntity> svcReplySelect(Long seq);
	public void svcReplyInsert(ReplyEntity rvo);
	public void svcBoardUpdate(BoardEntity bvo);
	public void svcBoardDelete(Long seq);
	public void svcReplyDelete(Long rseq);
}
