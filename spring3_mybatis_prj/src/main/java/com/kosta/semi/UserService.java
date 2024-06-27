package com.kosta.semi;

import java.util.ArrayList;

public interface UserService {
	public int svcUserInsert(UserVO uvo);
	public ArrayList<UserVO>  svcUserSelectAll();
	public UserVO svcUserSelectOne(UserVO uvo);
	public int svcUserUpdate(UserVO uvo);
	public int svcUserDelete(int seq);
	
}
