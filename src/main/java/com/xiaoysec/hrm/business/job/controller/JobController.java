package com.xiaoysec.hrm.business.job.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xiaoysec.hrm.business.job.entity.Job;
import com.xiaoysec.hrm.business.job.service.JobService;
import com.xiaoysec.hrm.common.base.DataGridResultEntity;
import com.xiaoysec.hrm.common.base.Page;

@Controller
@RequestMapping(value = "${adminPath}/job")
public class JobController {

	@Autowired
	private JobService jobService;

	@RequestMapping(value = { "", "list" })
	public String list() {
		return "/business/jobList";
	}

	@RequestMapping(value = "query")
	@ResponseBody
	public DataGridResultEntity query(HttpServletRequest request, Model model) {
		Page<Job> page = new Page<Job>(request);
		String name = request.getParameter("name");
		model.addAttribute("name", name);
		page = jobService.findList(page, model.asMap());
		return new DataGridResultEntity(page.getCount(), page.getList());
	}

	@RequestMapping(value = "form")
	public String form(Job job,Model model) {
		if(job.getId() != null){
			job = jobService.getJobById(job.getId());
		}
		model.addAttribute("job", job);
		return "/business/jobForm";
	}
	
	@RequestMapping(value = "delete")
	public String delete(Integer id){
		jobService.deleteJobById(id);
		return "/business/jobList";
	}
	
	@RequestMapping(value = "save")
	@ResponseBody
	public Map save(Job job,String hideName,HttpSession session){
		return jobService.save(job,hideName,session);
	}
	
	@RequestMapping(value = "lookup")
	public String lookup(Integer selId,Model model){
		model.addAttribute("selId", selId);
		return "/business/jobLookup";
	}
	
	@RequestMapping(value = "lookupTable")
	@ResponseBody
	public DataGridResultEntity lookupTable(HttpServletRequest request){
		Page<Job> page = new Page<Job>(request);
		page = jobService.findList(page, new HashMap<String,Object>());
		return new DataGridResultEntity(page.getCount(),page.getList());
	}
	
	
	
}
