package com.xiaoysec.hrm.business.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.business.user.mapper.UserMapper;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUser(User user) {
		return userMapper.getUserByLoginNameAndPassword(user);
	}

}
