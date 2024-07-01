package com.kosta.semi.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kosta.semi.jpa.BoardRepository;
import com.kosta.semi.jpa.entity.BoardEntity;

@Service
public class BoardServiceImpl implements BoardService {
	//---------------------------------------------------
	@Autowired
    private BoardRepository boardRepository;
	
	

    
		
    public List<BoardEntity> svcBoardList() {
    	return boardRepository.findAll();
	}
    
    public BoardEntity svcBoardDetail(Long boardSeq) {
    	return boardRepository.findOne(boardSeq);
    }
    
    public void svcBoardUpdate(BoardEntity BoardEntity) {
    	boardRepository.save(BoardEntity);
    }
	public void svcBoardDelete(Long boardSeq) {
		boardRepository.delete(boardSeq);
	}
	
    	
	/**
 	//select count(1) from users3;
	boardRepository.count();
	
	//delete from users3 where userSeq= ?
	boardRepository.delete(Long id);
	//delete from users3 where userId= ? and userPw=? and userName=?
	boardRepository.delete(BoardEntity entity);
	//delete from users3;
	boardRepository.deleteAll();
	
	//select * from users3 wehre userSeq=?
	boardRepository.exists(Long id);
	
	//select * from users3;
	boardRepository.findAll()
	//sub.. sub.. sub..select * from users3 where~~~ rnum between 1 and 10;
	boardRepository.findAll(Pageable);
	//select * from users3 order by userName asc, userSeq desc;
	boardRepository.findAll(Sort)
	
	//select * from users3 where userSeq=?
	boardRepository.findOne(Long id);
	boardRepository.getOne(Long id);
	
	//insert into users3 (...)
	//update users3 set (...)
	boardRepository.save(BoardEntity entity);
	
	//사용자가 추가 -- 
	boardRepository.findByUserIdAndUserPw(String, Stirng);    
 */
    
    
	//---------------------------------------------------
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	@Override
//	@Transactional
//	public List<BoardEntity> svcUserList() {
//		@SuppressWarnings("unchecked") //ignore generic type compile warning
//		List<BoardEntity> list = (List<BoardEntity>)sessionFactory.getCurrentSession()
//														.createCriteria(BoardEntity.class)
//														.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
//		return list;
//	}
	
	

}
