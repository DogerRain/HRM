package com.xiaoysec.hrm.business.job.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.job.entity.Job;
import com.xiaoysec.hrm.common.base.Page;
import com.xiaoysec.hrm.common.utils.StringUtil;

import static com.xiaoysec.hrm.common.global.Constants.JOBTABLE;

public class JobSqlProvider{
	
	//分页动态查询
	public String selectWithParm(final Map<String,Object> parm){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(JOBTABLE);
				if(parm.get("job") != null){
					Job job = (Job) parm.get("job");
					if(!StringUtil.isEmpty(job.getName())){
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
					if(!StringUtil.isEmpty(job.getName())){
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
				if(!StringUtil.isEmpty(job.getName())){
					VALUES("name",job.getName());
				}
				if(!StringUtil.isEmpty(job.getRemark())){
					VALUES("remark", job.getRemark());
				}
			}
		}.toString();
	}
	
	public String updateJob(final Job job){
		return new SQL(){
			{
				UPDATE(JOBTABLE);
				if(!StringUtil.isEmpty(job.getName())){
					SET(" name = #{name}");
				}
				if(!StringUtil.isEmpty(job.getRemark())){
					SET(" remark = #{remark}");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
	}
	
}
