package com.xiaoysec.hrm.business.employee.mapper;

import static com.xiaoysec.hrm.common.global.Constants.EMPLOYEETABLE;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.employee.entity.Employee;
import com.xiaoysec.hrm.common.base.Page;

public class EmployeeSqlProvider {

	//条件查询记录数
	public String getEmployeeCount(final Map<String,Object> parm){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(EMPLOYEETABLE);
				if(parm.get("employee") != null){
					Employee employee = (Employee) parm.get("employee");
					if(employee.getDepartment() != null && employee.getDepartment().getId() != null){
						WHERE(" dept_id = #{employee.department.id}");
					}
					if(employee.getJob() != null && employee.getJob().getId() != null){
						WHERE(" job_id = #{employee.job.id}");
					}
					if(!StringUtils.isBlank(employee.getName())){
						WHERE(" name like "+" %"+"#{employee.name}"+"% ");
					}
					if(!StringUtils.isBlank(employee.getCardId())){
						WHERE(" card_id like "+" %"+"#{employee.cardId}"+"% ");
					}
					if(employee.getSex()!=null){
						WHERE(" sex like "+" %"+"#{employee.sex}"+"% ");
					}
				}
			}
		}.toString();
	}
	
	//分页查询
	public String selectWithParm(final Map<String,Object> parm){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(EMPLOYEETABLE);
				if(parm.containsKey("employee")){
					Employee employee = (Employee) parm.get("employee");
					if(employee.getDepartment() != null && employee.getDepartment().getId() != null){
						WHERE(" dept_id = #{employee.department.id}");
					}
					if(employee.getJob() != null && employee.getJob().getId() != null){
						WHERE(" job_id = #{employee.job.id}");
					}
					if(!StringUtils.isBlank(employee.getName())){
						WHERE(" name like "+" %"+"#{employee.name}"+"% ");
					}
					if(!StringUtils.isBlank(employee.getCardId())){
						WHERE(" card_id like "+" %"+"#{employee.cardId}"+"% ");
					}
					if(employee.getSex()!=null){
						WHERE(" sex like "+" %"+"#{employee.sex}"+"% ");
					}
				}
			}
		}.toString();
		if(parm.get("page")!=null){
			Page page = (Page) parm.get("page");
			sql += " limit #{page.start},#{page.size} ";
		}
		return sql;
	}
	
	//动态插入
	public String insertEmployee(final Employee employee){
		return new SQL(){
			{
				INSERT_INTO(EMPLOYEETABLE);
				if(!StringUtils.isBlank(employee.getName())){
					VALUES("name", "#{name}");
				}
				if(!StringUtils.isBlank(employee.getCardId())){
					VALUES("card_id", "#{cardId}");
				}
				if(!StringUtils.isBlank(employee.getAddress())){
					VALUES("address", "#{address}");
				}
				if(!StringUtils.isBlank(employee.getAddress())){
					VALUES("address", "#{address}");
				}
				if(!StringUtils.isBlank(employee.getPostCode())){
					VALUES("post_code", "#{postCode}");
				}
				if(!StringUtils.isBlank(employee.getTel())){
					VALUES("tel", "#{tel}");
				}
				if(!StringUtils.isBlank(employee.getPhone())){
					VALUES("phone", "#{phone}");
				}
				if(!StringUtils.isBlank(employee.getQqNum())){
					VALUES("qq_num", "#{QqNum}");
				}
				if(!StringUtils.isBlank(employee.getEmail())){
					VALUES("email", "#{email}");
				}
				if(employee.getSex() != null){
					VALUES("sex", "#{sex}");
				}
				if(!StringUtils.isBlank(employee.getParty())){
					VALUES("party", "#{party}");
				}
				if(employee.getBirthday() != null){
					VALUES("birthday", "#{birthday}");
				}
				if(!StringUtils.isBlank(employee.getRace())){
					VALUES("race", "#{race}");
				}
				if(!StringUtils.isBlank(employee.getEdcation())){
					VALUES("education", "#{education}");
				}
				if(!StringUtils.isBlank(employee.getSpeciality())){
					VALUES("speciality", "#{speciality}");
				}
				if(!StringUtils.isBlank(employee.getHobby())){
					VALUES("hobby", "#{hobby}");
				}
				if(!StringUtils.isBlank(employee.getRemark())){
					VALUES("remark", "#{remark}");
				}
				if(employee.getCreateDate() != null){
					VALUES("creat_date", "#{create_date}");
				}
				if(employee.getDepartment() != null){
					VALUES("dept_id", "#{department.id}");
				}
				if(employee.getJob() != null){
					VALUES("job_id", "#{job.id}");
				}
			}
		}.toString();
	}
	
	//动态更新
	public String updateEmployee(final Employee employee){
		return new SQL(){
			{
				UPDATE(EMPLOYEETABLE);
				if(!StringUtils.isBlank(employee.getName())){
					SET("name = #{name}");
				}
				if(!StringUtils.isBlank(employee.getCardId())){
					SET("card_id = #{cardId}");
				}
				if(!StringUtils.isBlank(employee.getAddress())){
					SET("address = #{address}");
				}
				if(!StringUtils.isBlank(employee.getAddress())){
					SET("address = #{address}");
				}
				if(!StringUtils.isBlank(employee.getPostCode())){
					SET("post_code = #{postCode}");
				}
				if(!StringUtils.isBlank(employee.getTel())){
					SET("tel = #{tel}");
				}
				if(!StringUtils.isBlank(employee.getPhone())){
					SET("phone = #{phone}");
				}
				if(!StringUtils.isBlank(employee.getQqNum())){
					SET("qq_num = #{QqNum}");
				}
				if(!StringUtils.isBlank(employee.getEmail())){
					SET("email = #{email}");
				}
				if(employee.getSex() != null){
					SET("sex = #{sex}");
				}
				if(!StringUtils.isBlank(employee.getParty())){
					SET("party = #{party}");
				}
				if(employee.getBirthday() != null){
					SET("birthday = #{birthday}");
				}
				if(!StringUtils.isBlank(employee.getRace())){
					SET("race = #{race}");
				}
				if(!StringUtils.isBlank(employee.getEdcation())){
					SET("education = #{education}");
				}
				if(!StringUtils.isBlank(employee.getSpeciality())){
					SET("speciality = #{speciality}");
				}
				if(!StringUtils.isBlank(employee.getHobby())){
					SET("hobby = #{hobby}");
				}
				if(!StringUtils.isBlank(employee.getRemark())){
					SET("remark = #{remark}");
				}
				if(employee.getCreateDate() != null){
					SET("creat_date = #{create_date}");
				}
				if(employee.getDepartment() != null){
					SET("dept_id = #{department.id}");
				}
				if(employee.getJob() != null){
					SET("job_id = #{job.id}");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
	}
}
