package com.xiaoysec.hrm.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaoysec.hrm.business.user.service.UserService;

/**
 * 登录控制器 
 * @author xiaoysec
 *
 */

@Controller
@RequestMapping(value="${adminPath}")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="login",method=RequestMethod.GET)
	public String login(){
		return "sys/sysLogin";
	}
}
