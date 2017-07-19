package com.xiaoysec.hrm.business.document.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.xiaoysec.hrm.business.document.entity.Document;
import com.xiaoysec.hrm.business.document.mapper.DocMapper;
import com.xiaoysec.hrm.common.base.Page;

@Service
@Transactional(readOnly = true)
public class DocService {

	@Autowired
	private DocMapper docMapper;

	
	//分页查询
	public Page<Document> findList(Page<Document> page, Map<String, Object> param) {
		Map<String, Object> query = new HashMap<String,Object>(); 
		String title =  (String) param.get("title");
		if(StringUtils.isNotBlank(title)){
			query.put("title", title);
			query.put("mode", "like");
		}
		Integer start = page.getStart();
		Integer size = page.getSize();
		query.put("start", start);
		query.put("size", size);
		page.setList(docMapper.findList(query));
		page.setCount(docMapper.getDocCount(query));
		return page;
	}

	public Document getDocById(Integer id) {
		return null;
	}

	public Map save(Document document) {
		return null;
	}

	public Map upload(Document document, HttpSession session) {
		return null;
	}

	public ResponseEntity<byte[]> download(String fileName) {
		return null;
	}
}
