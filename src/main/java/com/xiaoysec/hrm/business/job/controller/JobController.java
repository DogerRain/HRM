package com.xiaoysec.hrm.business.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoysec.hrm.business.job.service.JobService;

@Controller
@RequestMapping(value="${adminPath}/job")
public class JobController {
	
	@Autowired
	private JobService jobService;
}
