package com.xiaoysec.hrm.business.notice.mapper;

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

import com.xiaoysec.hrm.business.notice.entity.Notice;

public interface NoticeMapper {
	
	//根据id查询
	@Select("select * from notice_info where id=#{id}")
	@Results({
		@Result(column="create_date",property="createDate"),
		@Result(column="user_id",property="User",
			one=@One(select="com.xiaoysec.hrm.business.user.mapper.UserMapper.selectUserById",
			fetchType=FetchType.EAGER)
		)
	})
	public Notice selectNoticeById(Integer id);
	
	//根据id删除
	@Delete("delete from notice_info where id=#{id}")
	public void deleteNoticeById(Integer id);

	//动态查询
	@SelectProvider(type=NoticeSqlProvider.class,method="selectWithParm")
	@Results({
		@Result(id=true,column="id",property="id"),
		@Result(column="create_date",property="createDate"),
		@Result(column="user_id",property="user",
			one=@One(select="com.xiaoysec.hrm.business.user.mapper.UserMapper.selectUserById",fetchType=FetchType.EAGER)
		)
	})
	public List<Notice> findNotice(Map<String,Object> parm);
	
	//动态查询数量
	@SelectProvider(type=NoticeSqlProvider.class,method="getNoticeCount")
	public Integer getNoticeCount(Map<String,Object> parm);
	
	//动态插入
	@InsertProvider(type=NoticeSqlProvider.class,method="insertNotice")
	public void addNotice(Notice notice);
	
	//动态更新
	@UpdateProvider(type=NoticeSqlProvider.class,method="updateNotice")
	public void updateNotice(Notice notice);
}
