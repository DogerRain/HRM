package com.xiaoysec.hrm.business.document.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoysec.hrm.business.document.service.DocService;

@Controller
@RequestMapping(value="${adminPath}/doc")
public class DocController {

	@Autowired
	private DocService docService;
}
