package com.xiaoysec.hrm.business.user.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.xiaoysec.hrm.business.user.entity.User;

import static com.xiaoysec.hrm.common.global.Constants.USERTABLE;

import java.util.List;
import java.util.Map;;

public interface UserMapper {

	// 使用登录名和密码查询用户
	public User getUserByLoginNameAndPassword(User user);
	
	//根据id获取user
	public User getUserById(Integer id);

	//根据id删除
	public void deleteUserById(Integer id);
	
	//动态修改用户信息
	public void updateUser(User user);
	
	//动态查询用户信息
	public List<User> findUser(Map<String,Object> parm);
	
	//动态查询用户数量
	public Integer getUserCount(Map<String,Object> parm);
	
	public void addUser(User user);
}
