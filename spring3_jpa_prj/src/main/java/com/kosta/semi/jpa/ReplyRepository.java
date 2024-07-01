package com.kosta.semi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.semi.jpa.entity.ReplyEntity;

@Repository
public interface ReplyRepository extends JpaRepository<ReplyEntity, Long> {
    //UserEntity findByUserIdAndUserPw(String userId, String userPw);
	
//	List<ReplyEntity> findBySeq(Long seq);
}