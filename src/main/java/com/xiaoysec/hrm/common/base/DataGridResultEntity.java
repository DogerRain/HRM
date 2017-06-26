package com.xiaoysec.hrm.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * DataGrid的返回结果
 * @author xiaoysec
 *
 */
public class DataGridResultEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private long total;
	private List<?> rows;
	
	
	public DataGridResultEntity(){
		super();
	}
	
	public DataGridResultEntity(long total,List<?> rows){
		this.total = total;
		this.rows  = rows;
	}
	
	

}
