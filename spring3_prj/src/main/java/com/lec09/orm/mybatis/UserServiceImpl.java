package com.lec09.orm.mybatis;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional   //DataSourceTXManager를 통한 트랜잭션 관리 대상 : 문제발생 시 롤백
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO userDAO;

	public int userInsert(UserVO uvo) {
		return userDAO.userInsert(uvo);
	}

	public ArrayList<UserVO>  userSelectAll() {
		return userDAO.userSelectAll();
	}

	public UserVO userSelectOne(UserVO uvo) {
		return userDAO.userSelectOne(uvo);
	}

	public int userUpdate(UserVO uvo) {
		return userDAO.userUpdate(uvo);
	}

	public int userDelete(UserVO uvo) {
		return userDAO.userDelete(uvo);
	}



	
	
}
