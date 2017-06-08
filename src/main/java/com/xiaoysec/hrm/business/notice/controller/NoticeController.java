package com.xiaoysec.hrm.business.notice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xiaoysec.hrm.business.notice.service.NoticeService;

@Controller
@RequestMapping(value="${adminPath}/notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
}
