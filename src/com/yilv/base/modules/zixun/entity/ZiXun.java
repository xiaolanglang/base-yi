package com.yilv.base.modules.zixun.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yilv.base.common.entity.DataEntity;
import com.yilv.base.modules.account.entity.Account;

/**
 * YiZixun entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "yi_zixun", catalog = "yi")
public class ZiXun extends DataEntity<ZiXun> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account yiUser;
	private String content;

	// Constructors

	/** default constructor */
	public ZiXun() {
	}

	/** full constructor */
	public ZiXun(Account yiUser, String content) {
		this.yiUser = yiUser;
		this.content = content;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	public Account getYiUser() {
		return this.yiUser;
	}

	public void setYiUser(Account yiUser) {
		this.yiUser = yiUser;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}