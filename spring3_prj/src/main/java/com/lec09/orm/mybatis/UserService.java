package com.lec09.orm.mybatis;

import java.util.ArrayList;

public interface UserService {
	public int userInsert(UserVO uvo);
	public ArrayList<UserVO>  userSelectAll(); 
		public UserVO userSelectOne(UserVO uvo); 
			public int userUpdate(UserVO uvo) ;
			public int userDelete(UserVO uvo);
}
