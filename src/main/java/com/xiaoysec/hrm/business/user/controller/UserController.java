package com.xiaoysec.hrm.business.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.business.user.service.UserService;

@Controller
@RequestMapping(value = "${adminPath}/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "query", "" },method={RequestMethod.GET})
	public String getUser(User _user, Model model) {
		User user = userService.getUser(_user);
		model.addAttribute("user", user);
		return "userList";
	}
	
	@RequestMapping(value="save",method={RequestMethod.GET})
	public void addUser(User user){
		userService.addUser(user);
	}
}
