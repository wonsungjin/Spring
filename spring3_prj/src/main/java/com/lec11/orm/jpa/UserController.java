package com.lec11.orm.jpa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lec11.orm.jpa.entity.UserEntity;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/jpa_detail")
	//http://localhost:8087/jpa_detail?userId=admin&userPw=000
	public String ctlUserLogin(ModelMap model, @ModelAttribute UserEntity userEntity) {
		//UserEntity userEntity = userService.svcUserLogin("admin","0000");
		userEntity = userService.svcUserLogin(userEntity.getUserId(),userEntity.getUserPw());
		model.addAttribute("MY_ENTITY", userEntity);
		System.out.println(userEntity.toString());
		return "hello";
	}
	
//	@RequestMapping(value="/jpa_list")
//	public String ctlUserList(ModelMap model) {
//		List<UserEntity> list = userService.svcUserList();
//		model.addAttribute("MY_LIST", list);
//		System.out.println(list.toString());
//		return "hello";
//	}

}
