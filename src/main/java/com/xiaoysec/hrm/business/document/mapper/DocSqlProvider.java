package com.xiaoysec.hrm.business.document.mapper;

import static com.xiaoysec.hrm.common.global.Constants.DOCUMENTTABLE;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.document.entity.Document;
import com.xiaoysec.hrm.common.base.Page;

public class DocSqlProvider {
	
	//分页查询
	public String selectWithParm(final Map<String,Object> parm){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(DOCUMENTTABLE);
				if(parm.containsKey("doc")){
					Document document = (Document) parm.get("doc");
					if(!StringUtils.isBlank(document.getTitle())){
						WHERE(" title like "+" %"+"#{document.title}"+"% ");
					}
					if(!StringUtils.isBlank(document.getFileName())){
						WHERE(" filename like "+" %"+"#{document.fileName}"+"% ");
					}
				}
			}
		}.toString();
		if(parm.containsKey("page")){
			Page page = (Page) parm.get("page");
			sql += " limit #{page.start},#{page,size}";
		}
		return sql;
	}
	
	//获取数量
	public String getDocCount(final Map<String,Object> parm){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(DOCUMENTTABLE);
				if(parm.containsKey("doc")){
					Document document = (Document) parm.get("doc");
					if(!StringUtils.isBlank(document.getTitle())){
						WHERE(" title like "+" %"+"#{document.title}"+"% ");
					}
					if(!StringUtils.isBlank(document.getFileName())){
						WHERE(" filename like "+" %"+"#{document.fileName}"+"% ");
					}
				}
			}
		}.toString();
	}
	
	//动态插入
	public String insertDoc(final Document document){
		return new SQL(){
			{
				INSERT_INTO(DOCUMENTTABLE);
				if(!StringUtils.isBlank(document.getFileName())){
					VALUES("filename", "#{fileName}");
				}
				if(!StringUtils.isBlank(document.getRemark())){
					VALUES("remark", "#{remark}");
				}
				if(!StringUtils.isBlank(document.getTitle())){
					VALUES("title", "#{title}");
				}
				if(document.getUser().getId() != null){
					VALUES("user_id", "#{user.id}");
				}
				if(document.getCreateDate() != null){
					VALUES("create_date", "#{createDate}");
				}
			}
		}.toString();
	}
	
	//动态更新
	public String updateDoc(final Document document){
		return new SQL(){
			{
				UPDATE(DOCUMENTTABLE);
				if(!StringUtils.isBlank(document.getFileName())){
					SET("filename = #{fileName}");
				}
				if(!StringUtils.isBlank(document.getRemark())){
					SET("remark = #{remark}");
				}
				if(!StringUtils.isBlank(document.getTitle())){
					SET("title = #{title}");
				}
				if(document.getUser().getId() != null){
					SET("user_id = #{user.id}");
				}
				if(document.getCreateDate() != null){
					SET("create_date = #{createDate}");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
	}

}
