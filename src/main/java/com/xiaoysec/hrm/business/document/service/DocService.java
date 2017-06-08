package com.xiaoysec.hrm.business.document.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xiaoysec.hrm.business.document.mapper.DocMapper;

@Service
public class DocService {

	@Autowired
	private DocMapper docMapper;
}
