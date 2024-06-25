package com.lec09.orm.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class UserController {
	@Autowired
	UserService userService; //= new UserServiceImple();
	 
  @RequestMapping(value = "/insert", method = RequestMethod.GET)
  public String userInsert() {
	  UserVO uvo = new UserVO();
	  uvo.setUserId("u");
	  uvo.setUserPw("w");
	  uvo.setUserName("w");
	  uvo.setUserGubun("a");
  	int insertRows = userService.userInsert(uvo);
  	return "hello"; 
  }
}
