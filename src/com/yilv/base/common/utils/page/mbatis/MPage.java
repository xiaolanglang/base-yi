package com.yilv.base.common.utils.page.mbatis;

import java.io.Serializable;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.yilv.base.common.conf.Global;

/**
 * 自定义分页对象
 * 
 * @author yourName
 * @version 2015-6-18
 */
public class MPage<E> implements Serializable {

	private static final long serialVersionUID = 1L;

	private com.github.pagehelper.Page<E> page;
	private List<E> list;

	/**
	 * 当前页数
	 */
	private int pageNum;

	/**
	 * 每页大小
	 */
	private int pageSize;

	/**
	 * 总页数
	 */
	private int pages;

	/**
	 * 记录总数
	 */
	private long totalCount;

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public long getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(long totalCount) {
		this.totalCount = totalCount;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public MPage() {
		this.pageSize = Global.getPageSize();
		this.pageNum = 1;
	}

	public MPage(Integer pageNum) {
		if (pageNum == null) {
			pageNum = 1;
		}
		this.pageSize = Global.getPageSize();
		this.pageNum = pageNum;
	}

	/**
	 * 开始分页
	 */
	public void start() {
		page = PageHelper.startPage(pageNum, pageSize, true);
	}

	public void end() {
		this.totalCount = page.getTotal();
		this.pages = page.getPages();
		this.list = page.getResult();
		page = null;
	}
}
