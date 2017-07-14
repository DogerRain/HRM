package com.xiaoysec.hrm.business.job.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoysec.hrm.business.job.entity.Job;

public interface JobMapper {

	public Integer getJobCount(Map<String, Object> parm);

	// 分页查询
	public List<Job> findJob(Map<String, Object> parm);

	public Job getJobById(Integer id);

	// 根据id删除
	public void deleteJobById(Integer id);

	// 更新
	public void updateJob(Job job);

	// 新增
	public void addJob(Job job);

}
