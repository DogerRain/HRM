package com.xiaoysec.hrm.business.user.mapper;

import static com.xiaoysec.hrm.common.global.Constants.USERTABLE;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.common.base.Page;

public class UserSqlProvider {
	
	//动态更新用户信息
	public String updateUser(User user){
		final User temp = user;
		return new SQL(){
			{
				UPDATE(USERTABLE);
				if(temp.getUsername() != null){
					SET(" username = #{username} ");
				}
				if(temp.getLoginname() != null){
					SET(" loginname = #{loginname} ");
				}
				if(temp.getPassword() != null){
					SET(" password = #{password} ");
				}
				if(temp.getStatus() != null){
					SET(" status = #{status} ");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
	}
	
	//动态查询用户信息(分页查询)
	public String selectWithParm(Map<String,Object> parm){
		final Map<String,Object> temp = parm;
		String sql = new SQL(){
			{	
				SELECT("*");
				FROM(USERTABLE);
				if(temp.get("user") != null){
					User user = (User)temp.get("user");
					if(!StringUtils.isBlank(user.getUsername())){
						WHERE(" username like %"+"#{user.username}"+"% ");
					}
					if(user.getStatus() != null){
						WHERE(" status like %"+"#{user.status}"+"% ");
					}
				}
			}
		}.toString();
		if(parm.get("page")!=null){
			Page page = (Page)parm.get("page");
			sql += " limit #{page.start},#{page.size} ";
		}
		return sql;
	}
	
	//动态查询总的记录数
	public String getUserCount(final Map<String,Object> parm){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(USERTABLE);
				if(parm.get("user") !=null ){
					User user = (User)parm.get("user");
					if(!StringUtils.isBlank(user.getUsername()))
						WHERE(" username like " + " %"+"#{user.username}"+"% ");
					if(user.getStatus() != null){
						WHERE(" status like " + " %"+"#{user.status}"+"% " );
					}
				}
			}
		}.toString();
	}
	
	//动态插入用户信息
	public String insertUser(final User user){
		return new SQL(){
			{
				INSERT_INTO(USERTABLE);
				if(!StringUtils.isBlank(user.getLoginname())){
					VALUES("loginname", "#{loginname}");
				}
				if(!StringUtils.isBlank(user.getUsername())){
					VALUES("username", "#{username}");
				}
				if(!StringUtils.isBlank(user.getPassword())){
					VALUES("password", "#{password}");
				}
				if(user.getStatus() != null){
					VALUES("status", "#{status}");
				}
				if(user.getCreateDate() != null){
					VALUES("create_date"," #{createDate}");
				}
			}
		}.toString();
	}

}
