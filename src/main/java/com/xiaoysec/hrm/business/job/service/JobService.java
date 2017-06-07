package com.xiaoysec.hrm.business.job.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.job.mapper.JobMapper;

@Service
@Transactional(readOnly=true)
public class JobService {
	
	@Autowired
	private JobMapper jobMapper;
	
}
