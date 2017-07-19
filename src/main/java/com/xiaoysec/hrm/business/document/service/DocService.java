package com.xiaoysec.hrm.business.document.service;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xiaoysec.hrm.business.document.entity.Document;
import com.xiaoysec.hrm.business.document.mapper.DocMapper;
import com.xiaoysec.hrm.business.user.entity.User;
import com.xiaoysec.hrm.common.base.Page;
import com.xiaoysec.hrm.common.utils.FileUtils;

@Service
@Transactional(readOnly = true)
public class DocService {

	@Autowired
	private DocMapper docMapper;

	// 分页查询
	public Page<Document> findList(Page<Document> page, Map<String, Object> param) {
		Map<String, Object> query = new HashMap<String, Object>();
		String title = (String) param.get("title");
		if (StringUtils.isNotBlank(title)) {
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
		return docMapper.getDocById(id);
	}

	@Transactional(readOnly = false)
	public Map upload(Document document, HttpSession session, String hideTitle) {
		User user = (User) session.getAttribute("sessionUser");
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			if(StringUtils.isBlank(document.getTitle())){
				result.put("success", false);
				result.put("message", "文件名称不能为空");
				return result;
			}
			if (!hideTitle.equals(document.getTitle())) {
				// 与原名字不相同 查重
				boolean isExist = isExist(document);
				if(isExist){
					result.put("success", false);
					result.put("message", "文件【"+document.getTitle()+"】已存在");
					return result;
				}
			}
			if(document.getId() == null){
				//新建
				if(document.getFile() == null){
					result.put("success", false);
					result.put("message", "请上传文件");
					return result;
				}
				HashMap<String, Object> fileMap = new HashMap<String,Object>();
				fileMap.put("word", 1);
				fileMap.put("csv", 2);
				fileMap.put("ppt", 3);
				fileMap.put("excel", 4);
				fileMap.put("txt", 5);
				//获取文件名称
				int fileTypeIndex = document.getFile().getOriginalFilename().trim().split("\\.").length-1;
				String realType = document.getFile().getOriginalFilename().split("\\.")[fileTypeIndex].toLowerCase();
				if(!fileMap.containsKey(realType)){
					result.put("success", false);
					result.put("message", "目前只支持word,csv,ppt,excel,txt格式的文件");
					return result;
				}
				String contextPath = session.getServletContext().getRealPath("/");
				String dirPath =  contextPath+"/file";
				boolean flag = FileUtils.createDirectory(dirPath);
				String fileName = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())+"_"+document.getFile().getOriginalFilename().toLowerCase();
				String realFileName =  dirPath + "/" + fileName;
				File file = new File(realFileName);
				document.getFile().transferTo(file);
				document.setCreateBy(user);
				document.setCreateDate(new Date());
				document.setFileName(fileName);
				docMapper.addDoc(document);
			}else{
				//修改
				document.setUpdateBy(user);
				document.setUpdateDate(new Date());
				docMapper.updateDoc(document);
			}
			result.put("success", true);
			result.put("message", "文件信息保存成功");
		} catch (Exception e) {
			if (document.getId() == null) {
				result.put("success", false);
				result.put("message", "文件上传失败");
			} else {
				result.put("success", false);
				result.put("message", "文件信息修改失败");
			}
		}
		return result;
	}

	private boolean isExist(Document document) {
		HashMap<String, Object> query = new HashMap<String,Object>();
		String title = document.getTitle();
		query.put("title", title);
		query.put("mode", "equals");
		Integer docCount = docMapper.getDocCount(query);
		return docCount>0;
	}

	@Transactional(readOnly = false)
	public ResponseEntity<byte[]> download(Integer fileId,HttpServletRequest request) throws IOException {
		Document doc = docMapper.getDocById(fileId);
		String fileName = doc.getFileName();
		String path = request.getSession().getServletContext().getRealPath("/")+"/file/"+fileName;
		File file = new File(path);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDispositionFormData("attachment", fileName);
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(org.apache.commons.io.FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}

	// 删除
	@Transactional(readOnly = false)
	public void deleteDocById(Integer id) {
		docMapper.deleteDocById(id);
	}
}
