package com.xiaoysec.hrm.business.job.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.job.entity.Job;
import com.xiaoysec.hrm.business.job.mapper.JobMapper;
import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.common.base.Page;

@Service
@Transactional(readOnly = true)
public class JobService {

	@Autowired
	private JobMapper jobMapper;

	// 分页查询
	public Page<Job> findList(Page<Job> page, Map<String, Object> param) {
		String name = (String) param.get("name");
		HashMap<String, Object> query = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(name)) {
			query.put("name", name);
			query.put("mode", "like");
		}
		int size = page.getSize();
		int start = page.getStart();
		query.put("size", size);
		query.put("start", start);
		List<Job> jobList = jobMapper.findJob(query);
		page.setList(jobList);
		page.setCount(jobMapper.getJobCount(query));
		return page;
	}

	public Job getJobById(Integer id) {
		return jobMapper.getJobById(id);
	}

	@Transactional(readOnly = false)
	public void deleteJobById(Integer id) {
		jobMapper.deleteJobById(id);
	}

	@Transactional(readOnly = false)
	public Map save(Job job, String hideName, HttpSession session) {
		User user = (User) session.getAttribute("sessionUser");
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			if (StringUtils.isBlank(job.getName())) {
				result.put("success", false);
				result.put("message", "名称不能为空");
				return result;
			}
			// 查重
			if (!hideName.equals(job.getName())) {
				boolean isExist = isExist(job);
				if (isExist) {
					result.put("success", false);
					result.put("message", "岗位【" + job.getName() + "】已经存在");
					return result;
				}
			}
			if (job.getId() != null) {
				job.setUpdateBy(user);
				job.setUpdateDate(new Date());
				jobMapper.updateJob(job);
			} else {
				job.setCreateBy(user);
				job.setCreateDate(new Date());
				jobMapper.addJob(job);
			}
			result.put("success", true);
			result.put("message", "岗位【" + job.getName() + "】保存成功");
		} catch (Exception e) {
			result.put("success", false);
			result.put("message", "岗位保存失败" + e.getMessage());
		}
		return result;
	}

	private boolean isExist(Job job) {
		HashMap<String, Object> param = new HashMap<String, Object>();
		param.put("name", job.getName());
		param.put("mode", "equals");
		Integer jobCount = jobMapper.getJobCount(param);
		return jobCount > 0;
	}

}
