package com.lec05.rest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller  + @ResponseBody 
public class TestRestControlerForRest {
	
	
	@RequestMapping(value = "/restctl_str_str" , method = RequestMethod.POST)
	public String ctlStrStr(Model model
			, @RequestParam("ename") String ename){
		System.out.println(ename);
		return "0. RestController 200 ok";	
	}
	
}
