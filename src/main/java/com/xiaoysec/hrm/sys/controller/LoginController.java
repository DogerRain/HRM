package com.xiaoysec.hrm.sys.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.business.user.service.UserService;
import com.xiaoysec.hrm.common.utils.StringUtil;

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
	
	@RequestMapping(value ="login",method=RequestMethod.GET)
	public String login(HttpServletRequest request){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user != null){
			//用户已经登陆过了，重定向到首页
			return "redirect:"+"/a";
		}
		return "sys/sysLogin";
	}
	
	@RequestMapping(value="login",method=RequestMethod.POST)
	public String login(User user,HttpServletRequest request){
		//判断是不是合法的用户
		if(!StringUtil.isEmpty(user.getLoginname())&&!StringUtil.isEmpty(user.getPassword())){
			User result = userService.getUser(user);
			if(result != null){
				request.getSession().setAttribute("sessionUser", result);
				return "redirect:"+"/a";
			}
		}
		return "sys/sysLogin";
	}
	
	@RequestMapping(value={"","index"})
	public String index(HttpServletRequest request){
		//判断是不是合法的用户
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("sessionUser");
		if(user == null){
			return "sys/sysLogin";
		}
		return "sys/sysIndex";
	}
}
