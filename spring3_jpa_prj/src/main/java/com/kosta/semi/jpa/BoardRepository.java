package com.kosta.semi.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kosta.semi.jpa.entity.BoardEntity;
import com.kosta.semi.jpa.entity.UserEntity;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, Long> {
    
}