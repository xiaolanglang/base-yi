package com.yilv.base.common.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.yilv.base.modules.account.entity.Account;

/**
 * 数据Entity类
 * 
 */
@JsonIgnoreProperties(value = { "updateBy", "updateDate", "createBy" })
@MappedSuperclass
public abstract class DataEntity<T> extends BaseEntity<T> {

	private static final long serialVersionUID = 1L;

	protected Account createBy; // 创建者
	protected Date createDate; // 创建日期
	protected Account updateBy; // 更新者
	protected Date updateDate; // 更新日期

	@Column(name = "create_time", nullable = false, length = 19)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name = "update_time", nullable = false, length = 19)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "create_by")
	public Account getCreateBy() {
		return createBy;
	}

	public void setCreateBy(Account createBy) {
		this.createBy = createBy;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "update_by")
	public Account getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(Account updateBy) {
		this.updateBy = updateBy;
	}

}
