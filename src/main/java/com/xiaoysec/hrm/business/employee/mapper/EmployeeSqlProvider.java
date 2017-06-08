package com.xiaoysec.hrm.business.employee.mapper;

import static com.xiaoysec.hrm.common.global.Constants.EMPLOYEETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.employee.entity.Employee;
import com.xiaoysec.hrm.common.base.Page;
import com.xiaoysec.hrm.common.utils.StringUtil;

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
					if(!StringUtil.isEmpty(employee.getName())){
						WHERE(" name like "+" %"+"#{employee.name}"+"% ");
					}
					if(!StringUtil.isEmpty(employee.getCardId())){
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
					if(!StringUtil.isEmpty(employee.getName())){
						WHERE(" name like "+" %"+"#{employee.name}"+"% ");
					}
					if(!StringUtil.isEmpty(employee.getCardId())){
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
				if(!StringUtil.isEmpty(employee.getName())){
					VALUES("name", "#{name}");
				}
				if(!StringUtil.isEmpty(employee.getCardId())){
					VALUES("card_id", "#{cardId}");
				}
				if(!StringUtil.isEmpty(employee.getAddress())){
					VALUES("address", "#{address}");
				}
				if(!StringUtil.isEmpty(employee.getAddress())){
					VALUES("address", "#{address}");
				}
				if(!StringUtil.isEmpty(employee.getPostCode())){
					VALUES("post_code", "#{postCode}");
				}
				if(!StringUtil.isEmpty(employee.getTel())){
					VALUES("tel", "#{tel}");
				}
				if(!StringUtil.isEmpty(employee.getPhone())){
					VALUES("phone", "#{phone}");
				}
				if(!StringUtil.isEmpty(employee.getQqNum())){
					VALUES("qq_num", "#{QqNum}");
				}
				if(!StringUtil.isEmpty(employee.getEmail())){
					VALUES("email", "#{email}");
				}
				if(employee.getSex() != null){
					VALUES("sex", "#{sex}");
				}
				if(!StringUtil.isEmpty(employee.getParty())){
					VALUES("party", "#{party}");
				}
				if(employee.getBirthday() != null){
					VALUES("birthday", "#{birthday}");
				}
				if(!StringUtil.isEmpty(employee.getRace())){
					VALUES("race", "#{race}");
				}
				if(!StringUtil.isEmpty(employee.getEdcation())){
					VALUES("education", "#{education}");
				}
				if(!StringUtil.isEmpty(employee.getSpeciality())){
					VALUES("speciality", "#{speciality}");
				}
				if(!StringUtil.isEmpty(employee.getHobby())){
					VALUES("hobby", "#{hobby}");
				}
				if(!StringUtil.isEmpty(employee.getRemark())){
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
				if(!StringUtil.isEmpty(employee.getName())){
					SET("name = #{name}");
				}
				if(!StringUtil.isEmpty(employee.getCardId())){
					SET("card_id = #{cardId}");
				}
				if(!StringUtil.isEmpty(employee.getAddress())){
					SET("address = #{address}");
				}
				if(!StringUtil.isEmpty(employee.getAddress())){
					SET("address = #{address}");
				}
				if(!StringUtil.isEmpty(employee.getPostCode())){
					SET("post_code = #{postCode}");
				}
				if(!StringUtil.isEmpty(employee.getTel())){
					SET("tel = #{tel}");
				}
				if(!StringUtil.isEmpty(employee.getPhone())){
					SET("phone = #{phone}");
				}
				if(!StringUtil.isEmpty(employee.getQqNum())){
					SET("qq_num = #{QqNum}");
				}
				if(!StringUtil.isEmpty(employee.getEmail())){
					SET("email = #{email}");
				}
				if(employee.getSex() != null){
					SET("sex = #{sex}");
				}
				if(!StringUtil.isEmpty(employee.getParty())){
					SET("party = #{party}");
				}
				if(employee.getBirthday() != null){
					SET("birthday = #{birthday}");
				}
				if(!StringUtil.isEmpty(employee.getRace())){
					SET("race = #{race}");
				}
				if(!StringUtil.isEmpty(employee.getEdcation())){
					SET("education = #{education}");
				}
				if(!StringUtil.isEmpty(employee.getSpeciality())){
					SET("speciality = #{speciality}");
				}
				if(!StringUtil.isEmpty(employee.getHobby())){
					SET("hobby = #{hobby}");
				}
				if(!StringUtil.isEmpty(employee.getRemark())){
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
