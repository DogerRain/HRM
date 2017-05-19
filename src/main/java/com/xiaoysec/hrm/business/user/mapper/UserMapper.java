package com.xiaoysec.hrm.business.user.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.xiaoysec.hrm.business.user.entity.User;

import static com.xiaoysec.hrm.common.global.Constants.USERTABLE;;

public interface UserMapper {

	// 使用登录名和密码查询用户
	@Select(" select * from " + USERTABLE + " where loginname= #{loginname} and password = #{password} ")
	public User getUserByLoginNameAndPassword(User user);

}
