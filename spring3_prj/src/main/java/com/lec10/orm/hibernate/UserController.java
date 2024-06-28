package com.lec10.orm.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
	private UserService userImpl;
	
	@RequestMapping(value="/hiber")
	public String doAction(ModelMap model) {
		List<UserVO> list = userImpl.list();
		model.addAttribute("MY_LIST", list);
		System.out.println(list.toString());
		return "hello";
	}

}
