package com.xiaoysec.hrm.business.job.mapper;

import static com.xiaoysec.hrm.common.global.Constants.JOBTABLE;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.job.entity.Job;
import com.xiaoysec.hrm.common.base.Page;

public class JobSqlProvider{
	
	//分页动态查询
	public String selectWithParm(final Map<String,Object> parm){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(JOBTABLE);
				if(parm.get("job") != null){
					Job job = (Job) parm.get("job");
					if(!StringUtils.isBlank(job.getName())){
						WHERE(" name like "+" %"+"#{job.name}"+"% ");
					}
				}
			}
		}.toString();
		if(parm.get("page") != null){
			Page page = (Page) parm.get("page");
			sql += " limit #{page.start},#{page.size} ";
		}
		return sql;
	}
	
	public String getJobCount(final Map<String,Object> parm){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(JOBTABLE);
				if(parm.get("job")!=null){
					Job job = (Job) parm.get("job");
					if(!StringUtils.isBlank(job.getName())){
						WHERE(" name like"+" %"+"#{job.name}"+"% ");
					}
				}
			}
		}.toString();
	}
	
	public String insertJob(final Job job){
		return new SQL(){
			{
				INSERT_INTO(JOBTABLE);
				if(!StringUtils.isBlank(job.getName())){
					VALUES("name",job.getName());
				}
				if(!StringUtils.isBlank(job.getRemark())){
					VALUES("remark", job.getRemark());
				}
			}
		}.toString();
	}
	
	public String updateJob(final Job job){
		return new SQL(){
			{
				UPDATE(JOBTABLE);
				if(!StringUtils.isBlank(job.getName())){
					SET(" name = #{name}");
				}
				if(!StringUtils.isBlank(job.getRemark())){
					SET(" remark = #{remark}");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
	}
	
}
