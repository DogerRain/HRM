package com.xiaoysec.hrm.business.job.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.xiaoysec.hrm.business.job.entity.Job;
import static com.xiaoysec.hrm.common.global.Constants.JOBTABLE;

import java.util.List;
import java.util.Map;

public interface JobMapper {
	
	@Select("select * from "+ JOBTABLE + " where id=#{id}")
	public Job selectJobById(Integer id);
	
	@Select("select * from "+JOBTABLE)
	public List<Job> findJob();
	
	//根据id删除响应的职位
	@Delete("delete from "+ JOBTABLE + " where id=#{id}" )
	public void deleteJobById(Integer id);
	
	//动态获取职位的数量
	@SelectProvider(type=JobSqlProvider.class,method="getJobCount")
	public Integer getJobCount(Map<String,Object> parm);

	//动态查询职位信息
	@SelectProvider(type=JobSqlProvider.class,method="selectWithParm")
	public List<Job> findJob(Map<String,Object> parm);
	
	//动态插入职位信息
	@InsertProvider(type=JobSqlProvider.class,method="insertJob")
	public void addJob(Job job);
	
	//动态修改职位信息
	@UpdateProvider(type=JobSqlProvider.class,method="updateJob")
	public void updateJob(Job job);
	
}
