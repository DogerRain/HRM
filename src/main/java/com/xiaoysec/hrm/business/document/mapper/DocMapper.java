package com.xiaoysec.hrm.business.document.mapper;

import java.util.List;
import java.util.Map;

import com.xiaoysec.hrm.business.document.entity.Document;

public interface DocMapper {

	// 动态查询数量
	public Integer getDocCount(Map<String, Object> parm);

	//分页查询
	public List<Document> findList(Map<String, Object> query);

	//id查询
	public Document getDocById(Integer id);

	//删除
	public void deleteDocById(Integer id);

	//新增
	public void addDoc(Document document);

	//修改
	public void updateDoc(Document document);
}
