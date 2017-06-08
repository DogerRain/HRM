package com.xiaoysec.hrm.business.notice.mapper;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;
import static com.xiaoysec.hrm.common.global.Constants.NOTICETABLE;

import com.xiaoysec.hrm.business.notice.entity.Notice;
import com.xiaoysec.hrm.common.base.Page;
import com.xiaoysec.hrm.common.utils.StringUtil;

public class NoticeSqlProvider {
	
	//分页查询
	public String selectWithParm(final Map<String,Object> parm){
		String sql = new SQL(){
			{
				SELECT("*");
				FROM(NOTICETABLE);
				if(parm.containsKey("notice")){
					Notice notice = (Notice)parm.get("notice");
					if(!StringUtil.isEmpty(notice.getContent())){
						WHERE(" content like "+" %"+"#{notice.content}"+"% ");
					}
					if(!StringUtil.isEmpty(notice.getTitle())){
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
					if(!StringUtil.isEmpty(notice.getContent())){
						WHERE(" content like "+" %"+"#{notice.content}"+"% ");
					}
					if(!StringUtil.isEmpty(notice.getTitle())){
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
				if(!StringUtil.isEmpty(notice.getContent())){
					VALUES("content", "#{content}");
				}
				if(!StringUtil.isEmpty(notice.getTitle())){
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
				if(!StringUtil.isEmpty(notice.getTitle())){
					SET("title = #{title}");
				}
				if(!StringUtil.isEmpty(notice.getContent())){
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
