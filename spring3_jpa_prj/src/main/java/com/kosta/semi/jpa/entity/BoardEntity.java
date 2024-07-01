package com.kosta.semi.jpa.entity;

import javax.persistence.*;


import lombok.Data;

import java.util.Date;


/*<class name="UserVO" table="users3">
	<id name="userSeq" column="user_seq" />
	<property name="userId" column="user_id" />
	<property name="userPw" column="user_pw" />
	<property name="userName" column="user_name" />
	<property name="userGubun" column="user_gubun" />
	<property name="regdate" column="regdate" />
</class>*/

@Data
@Entity(name = "BoardEntityJPA")
@Table(name = "board")
public class BoardEntity {
    
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "board_seq_gen")
    @SequenceGenerator(name = "board_seq_gen", sequenceName = "board_seq", allocationSize = 1)
    @Column(name = "seq")
    private Long seq;
    
    @Column(name = "title", nullable = false, length = 30)
    private String title;
    
    @Column(name = "contents", nullable = false, length = 50)
    private String contents;
    
    @Column(name = "regid", nullable = false,length = 10)
    private String regid;
        
    @Column(name = "regdate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date regdate = new Date();

    // lombok : getters and setters
}