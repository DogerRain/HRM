package com.xiaoysec.hrm.common.base;

import java.io.Serializable;
import java.util.List;

/**
 * 动态table
 * 
 * @author xiaoysec
 *
 */
public class DataGridResultEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	// 总的记录数
	private long total;

	// 查询结果列表
	private List<?> rows;

	public DataGridResultEntity() {
		super();
	}

	public DataGridResultEntity(long total, List<?> rows) {
		this.total = total;
		this.rows = rows;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public List<?> getRows() {
		return rows;
	}

	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
