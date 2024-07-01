package com.kosta.semi.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kosta.semi.jpa.entity.UserEntity;
import com.kosta.semi.jpa.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value="/user_login")
	//http://localhost:8089/jpa_detail?userId=admin&userPw=0000
	public String ctlUserLogin(ModelMap model, @ModelAttribute UserEntity userEntity) {
		//UserEntity userEntity = userService.svcUserLogin("admin","0000");
		userEntity = userService.svcUserLogin(userEntity.getUserId(),userEntity.getUserPw());
		model.addAttribute("MY_ENTITY", userEntity);
		System.out.println(userEntity.toString());
		return "hello";
	}
	
	@RequestMapping(value="/user_list")
	//http://localhost:8089/jpa_list
	public String ctlUserList(ModelMap model) {
		List<UserEntity> list = userService.svcUserList();
		model.addAttribute("MY_LIST", list);
		System.out.println(list.toString());
		return "hello";
	}
	
	
	//http://localhost:8089/jpa_detail?userSeq=1
	//@RequestMapping(value="/jpa_detail")
	//public String ctlUserDetail(ModelMap model, @RequestParam("userSeq") int userSeq) {
		
	//http://localhost:8089/jpa_detail/1
	@RequestMapping(value="/user_detail/{aaa}")
	public String ctlUserDetail(ModelMap model, @PathVariable("aaa") Long userSeq) {
		UserEntity entity = userService.svcUserDetail(userSeq);
		model.addAttribute("MY_ENTITY", entity);
		System.out.println(entity.toString());
		return "hello";
	}

	//http://localhost:8089/jpa_update
	@RequestMapping(value="/user_update")
	public String ctlUserUpdate(ModelMap model, @ModelAttribute UserEntity userEntity) {
		//update users3 set user_pw=#{userPw} where user_id=#{userId}
		userEntity.setId(1L);
		userEntity.setUserId("admin");
		userEntity.setUserPw("444");
		userService.svcUserUpdate(userEntity);
		return "hello";
	}

	//http://localhost:8089/jpa_delete/1
	@RequestMapping(value="/user_delete/{aaa}")
	public String ctlUserDelete(ModelMap model, @PathVariable("aaa") Long userSeq) {
		//delete from users3 where user_seq=#{userSeq}
		userService.svcUserDelete(userSeq);
		return "hello";
	}
	
}
