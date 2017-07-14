package com.xiaoysec.hrm.business.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.business.user.service.UserService;
import com.xiaoysec.hrm.common.base.DataGridResultEntity;
import com.xiaoysec.hrm.common.base.Page;

/**
 * 用户控制器
 * 
 * @author xiaoysec
 *
 */
@Controller
@RequestMapping(value = "${adminPath}/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = { "", "list" })
	public String list() {
		return "/business/userList";
	}

	@RequestMapping(value = "query")
	@ResponseBody
	public DataGridResultEntity query(HttpServletRequest request) {
		Page<User> page = new Page<User>(request);
		String name = request.getParameter("name");
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("name", name);
		page = userService.findList(page, param);
		return new DataGridResultEntity(page.getCount(), page.getList());
	}

	@RequestMapping(value = "form")
	public String form(User user, Model model) {
		if (user.getId() != null) {
			user = userService.getUserById(user.getId());
		}
		model.addAttribute("user", user);
		return "/business/userForm";
	}

	@RequestMapping(value = "delete")
	public String delete(Integer id) {
		userService.deleteUserById(id);
		return "/business/userList";
	}

	@RequestMapping(value = "save")
	@ResponseBody
	public Map save(User user, String hideName) {
		return userService.save(user, hideName);
	}
}
