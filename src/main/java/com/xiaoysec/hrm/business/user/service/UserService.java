package com.xiaoysec.hrm.business.user.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.business.user.mapper.UserMapper;
import com.xiaoysec.hrm.common.base.Page;

@Service
@Transactional(readOnly = true)
public class UserService {

	@Autowired
	private UserMapper userMapper;

	// 根据登录名和密码查询
	public User getUser(User user) {
		return userMapper.getUserByLoginNameAndPassword(user);
	}

	// 分页查询
	public Page<User> findList(Page<User> page, Map<String, Object> param) {
		HashMap<String, Object> query = new HashMap<String, Object>();
		String name = (String) param.get("name");
		if (StringUtils.isNotBlank(name)) {
			query.put("name", name);
			query.put("mode", "like");
		}
		Integer start = page.getStart();
		Integer size = page.getSize();
		query.put("start", size);
		List<User> userList = userMapper.findUser(query);
		Integer count = userMapper.getUserCount(query);
		page.setCount(count);
		page.setList(userList);
		return page;
	}

	// 根据id查询用户
	public User getUserById(Integer id) {
		return userMapper.getUserById(id);
	}

	// 删除用户
	@Transactional(readOnly = false)
	public void deleteUserById(Integer id) {
		userMapper.deleteUserById(id);
	}

	// 保存用户
	@Transactional(readOnly = false)
	public Map save(User user, String hideName) {
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			if (StringUtils.isBlank(user.getLoginname())) {
				result.put("success", false);
				result.put("message", "登陆名不能为空");
				return result;
			}
			if (StringUtils.isBlank(user.getPassword())) {
				result.put("success", false);
				result.put("message", "密码不能为空");
				return result;
			}
			if (StringUtils.isBlank(user.getUsername())) {
				result.put("success", false);
				result.put("message", "用户名不能为空");
				return result;
			}
			//查重
			if(!hideName.equals(user.getLoginname())){
				boolean isExist = isExist(user);
				if(isExist){
					result.put("success", false);
					result.put("message", "登陆名【"+user.getLoginname()+"】已经存在");
					return result;
				}
			}
			if(user.getId() == null){
				//新增用户
				user.setCreateDate(new Date());
				user.setStatus(1);
				userMapper.addUser(user);
			}else{
				userMapper.updateUser(user);
			}
			result.put("success", true);
			result.put("message", "用户 【"+user.getLoginname()+"】保存成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "用户保存失败");
		}
		return result;
	}

	//查重
	public boolean isExist(User user) {
		HashMap<String, Object> param = new HashMap<String,Object>();
		param.put("mode", "equals");
		param.put("name", user.getLoginname());
		Integer userCount = userMapper.getUserCount(param);
		return userCount>0;
	}

}
