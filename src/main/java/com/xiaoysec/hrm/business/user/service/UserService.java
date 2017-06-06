package com.xiaoysec.hrm.business.user.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.business.user.mapper.UserMapper;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User getUser(User user) {
		return userMapper.getUserByLoginNameAndPassword(user);
	}
	
	public void addUser(User user){
		user.setCreateDate(new Date());
		userMapper.addUser(user);
	}

}
