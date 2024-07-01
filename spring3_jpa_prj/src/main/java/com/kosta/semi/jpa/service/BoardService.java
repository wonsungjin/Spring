package com.kosta.semi.jpa.service;

import java.util.List;

import com.kosta.semi.jpa.entity.BoardEntity;

public interface BoardService {	
	public List<BoardEntity> svcBoardList();
	BoardEntity svcBoardDetail(Long boardSeq);
	void svcBoardUpdate(BoardEntity boardEntity);
	void svcBoardDelete(Long boardSeq);
}
