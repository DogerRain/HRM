package com.xiaoysec.hrm.business.notice.mapper;

import static com.xiaoysec.hrm.common.global.Constants.NOTICETABLE;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

import com.xiaoysec.hrm.business.notice.entity.Notice;
import com.xiaoysec.hrm.common.base.Page;

public class NoticeSqlProvider {
	
	//分页查询
	public String selectWithParm(final Map<String,Object> parm){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(NOTICETABLE);
				if(parm.containsKey("notice")){
					Notice notice = (Notice)parm.get("notice");
					if(!StringUtils.isBlank(notice.getContent())){
						WHERE(" content like "+" %"+"#{notice.content}"+"% ");
					}
					if(!StringUtils.isBlank(notice.getTitle())){
						WHERE(" title like "+" %"+"#{notice.title}"+"% ");
					}
				}
			}
		}.toString();
		if(parm.containsKey("page")){
			Page page = (Page) parm.get("page");
			sql += " limit #{page.start},#{page.size}";
		}
		return sql;
	}
	
	//查询总数
	public String getNoticeCount(final Map<String,Object> parm){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(NOTICETABLE);
				if(parm.containsKey("notice")){
					Notice notice = (Notice)parm.get("notice");
					if(!StringUtils.isBlank(notice.getContent())){
						WHERE(" content like "+" %"+"#{notice.content}"+"% ");
					}
					if(!StringUtils.isBlank(notice.getTitle())){
						WHERE(" title like "+" %"+"#{notice.title}"+"% ");
					}
				}
			}
		}.toString();
	}
	
	//动态插入
	public String insertNotice(final Notice notice){
		return new SQL(){
			{
				INSERT_INTO(NOTICETABLE);
				if(!StringUtils.isBlank(notice.getContent())){
					VALUES("content", "#{content}");
				}
				if(!StringUtils.isBlank(notice.getTitle())){
					VALUES("title", "#{title}");
				}
				if(notice.getUser().getId() != null){
					VALUES("user_id", "#{user.id}");
				}
				if(notice.getCreateDate() != null){
					VALUES("create_date", "#{createDate}");
				}
			}
		}.toString();
	}

	//动态更新
	public String updateNotice(final Notice notice){
		return new SQL(){
			{
				UPDATE(NOTICETABLE);
				if(!StringUtils.isBlank(notice.getTitle())){
					SET("title = #{title}");
				}
				if(!StringUtils.isBlank(notice.getContent())){
					SET("content = #{content}");
				}
				if(notice.getUser() != null){
					SET("user_id = #{user.id}");
				}
				WHERE(" id = #{id}");
			}
		}.toString();
	}

}
