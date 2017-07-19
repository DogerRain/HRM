package com.xiaoysec.hrm.business.document.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoysec.hrm.business.document.entity.Document;
import com.xiaoysec.hrm.business.document.service.DocService;
import com.xiaoysec.hrm.common.base.DataGridResultEntity;
import com.xiaoysec.hrm.common.base.Page;

@Controller
@RequestMapping(value = "${adminPath}/doc")
public class DocController {

	@Autowired
	private DocService docService;

	@RequestMapping(value = { "", "list" })
	public String list() {
		return "/business/documentList";
	}

	@RequestMapping(value = "query")
	@ResponseBody
	public DataGridResultEntity query(HttpServletRequest request, Model model) {
		Page<Document> page = new Page<Document>(request);
		String name = request.getParameter("title");
		model.addAttribute("title", name);
		page = docService.findList(page, model.asMap());
		return new DataGridResultEntity(page.getCount(), page.getList());
	}

	@RequestMapping(value = "form")
	public String form(Document document, Model model) {
		if (document.getId() != null) {
			document = docService.getDocById(document.getId());
		}
		model.addAttribute("document", document);
		return "/business/documentForm";
	}

	@RequestMapping(value = "save")
	@ResponseBody
	public Map save(Document document) {
		return docService.save(document);
	}

	@RequestMapping(value = "upload")
	@ResponseBody
	public Map upload(Document document, HttpSession session) {
		return docService.upload(document, session);
	}
	
	@RequestMapping(value = "download")
	public ResponseEntity<byte[]> download(Document document){
		return docService.download(document.getFileName());
	}
}
