package com.kosta.semi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.semi.jpa.entity.BoardEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    //UserEntity findByUserIdAndUserPw(String userId, String userPw);
}