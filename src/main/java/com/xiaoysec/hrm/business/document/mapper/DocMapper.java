package com.xiaoysec.hrm.business.document.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.mapping.FetchType;

import com.xiaoysec.hrm.business.document.entity.Document;

public interface DocMapper {
	
	//根据id查询
	@Select("select * from document_info where id=#{id}")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="create_date",property="createDate"),
		@Result(column="user_id",property="user",
			one=@One(select="com.xiaoysec.hrm.business.user.mapper.UserMapper.selectUserById",fetchType=FetchType.EAGER)
		)
	})
	public Document selectDocById(Integer id);
	
	//根据id删除
	@Delete("delete from document_info where id=#{id}")
	public void deleteDocById(Integer id);
	
	//动态查询
	@SelectProvider(type=DocSqlProvider.class,method="selectWithParm")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="create_date",property="createDate"),
		@Result(column="user_id",property="user",
			one=@One(select="com.xiaoysec.hrm.business.user.mapper.UserMapper.selectUserById",fetchType=FetchType.EAGER)
		)
	})
	public List<Document> findDoc(Map<String,Object> parm);
	
	//动态查询数量
	@SelectProvider(type=DocSqlProvider.class,method="getDocCount")
	public Integer getDocCount(Map<String,Object> parm); 
	
	//动态插入
	@InsertProvider(type=DocSqlProvider.class,method="insertDoc")
	public void addDoc(Document document);
	
	//动态更新
	@UpdateProvider(type=DocSqlProvider.class,method="updateDoc")
	public void updateDoc(Document document);
}
