package com.yilv.base.modules.dongtai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yilv.base.common.entity.DataEntity;
import com.yilv.base.modules.account.entity.Account;

/**
 * YiCommentDongtai entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "yi_comment_dongtai")
public class DongTaiComment extends DataEntity<DongTaiComment> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account user;// 被评论人
	private DongTai dongTai;
	private String content;
	private String anonymous;

	// Constructors

	/** default constructor */
	public DongTaiComment() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dongtai_id")
	public DongTai getDongTai() {
		return dongTai;
	}

	public void setDongTai(DongTai dongTai) {
		this.dongTai = dongTai;
	}

	@Column(name = "content", length = 200)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "anonymous", length = 12)
	public String getAnonymous() {
		return this.anonymous;
	}

	public void setAnonymous(String anonymous) {
		this.anonymous = anonymous;
	}

}