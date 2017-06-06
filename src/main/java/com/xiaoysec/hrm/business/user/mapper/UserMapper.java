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
	@Select(" select * from " + USERTABLE + " where loginname= #{loginname} and password = #{password} ")
	public User getUserByLoginNameAndPassword(User user);
	
	//根据id获取user
	@Select(" select * from "+ USERTABLE +" where id=#{id}")
	public User selectUserById(Integer id);

	//根据id删除
	@Delete(" delete from "+ USERTABLE + " where id=#{id}")
	public void deleteUserById(Integer id);
	
	//动态修改用户信息
	@UpdateProvider(type=UserSqlProvider.class,method="updateUser")
	public void updateUser(User user);
	
	//动态查询用户信息
	@SelectProvider(type=UserSqlProvider.class,method="selectWithParm")
	public List<User> findUser(Map<String,Object> parm);
	
	//动态查询用户数量
	@SelectProvider(type=UserSqlProvider.class,method="getUserCount")
	public Integer getUserCount(Map<String,Object> parm);
	
	@InsertProvider(type=UserSqlProvider.class,method="insertUser")
	public void addUser(User user);
}
