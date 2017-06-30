package com.xiaoysec.hrm.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 分页类
 * @author xiaoysec
 * @param <T>
 *
 */
public class Page<T> implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private int start; //起始页
	
	private long count; //数据总条数 -1表示不查询总条数
	
	private int size=10; //页面大小 默认是10 -1表示不进行分页
	
	private String orderBy = ""; //标准查询有效
	
	private List<T> list = new ArrayList<T>(); //数据列表
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	@JsonIgnore
	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Page() {
		super();
	}
	
	/**
	 * 构造方法  整合dataTable和dataGrid
	 * @param request
	 */
	public Page(HttpServletRequest request){
		//dataTable (start和length分别设置起始索引和每页大小)
		String start = request.getParameter("start");
		String length = request.getParameter("length");
		
		//dataGrid (page和rows分别页数和每页的大小)
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		
		if(!StringUtils.isBlank(page)&&!StringUtils.isBlank(rows)){
			Integer startInt =Integer.valueOf(page);
			Integer rowsInt = Integer.valueOf(rows);
			start = (startInt-1)*rowsInt+"";
			length = rows;
		}
		if(StringUtils.isNumeric(start)){
			this.setStart(Integer.valueOf(start));
		}
		if(StringUtils.isNumeric(length)){
			this.setSize(Integer.valueOf(length));
		}
		//设置排序参数
		if(!StringUtils.isBlank(orderBy)){
			this.setOrderBy(orderBy);
		}
	}
	
	/**
	 * 构造方法
	 * @param request
	 * @param response
	 */
	public Page(HttpServletRequest request,HttpServletResponse response){
		this(request);
	}
	
	public Page(HttpServletRequest request,List<T> list){
		this(request);
		this.setCount(list.size());
//		this.list = processDataList(list);
		this.list = list;
	}
	

	/**
	 * 分页是否有效
	 * @return this.pageSize==-1
	 */
	@JsonIgnore
	public boolean isDisabled() {
		return this.size==-1;
	}
	
	/**
	 * 是否进行总数统计
	 * @return this.count==-1
	 */
	@JsonIgnore
	public boolean isNotCount() {
		return this.count==-1;
	}
	
}
