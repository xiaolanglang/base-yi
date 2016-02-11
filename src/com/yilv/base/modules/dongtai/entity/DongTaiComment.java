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
@Table(name = "yi_comment_dongtai", catalog = "yi")
public class DongTaiComment extends DataEntity<DongTaiComment> {

	private static final long serialVersionUID = 1L;
	private Account yiUserByUserId;
	private DongTaiComment yiCommentDongtai;
	private Account yiUserByCriticId;
	private DongTai yiDongtai;
	private String content;
	private String anonymous;

	// Constructors

	/** default constructor */
	public DongTaiComment() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public Account getYiUserByUserId() {
		return this.yiUserByUserId;
	}

	public void setYiUserByUserId(Account yiUserByUserId) {
		this.yiUserByUserId = yiUserByUserId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "parent_id")
	public DongTaiComment getYiCommentDongtai() {
		return this.yiCommentDongtai;
	}

	public void setYiCommentDongtai(DongTaiComment yiCommentDongtai) {
		this.yiCommentDongtai = yiCommentDongtai;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "critic_id")
	public Account getYiUserByCriticId() {
		return this.yiUserByCriticId;
	}

	public void setYiUserByCriticId(Account yiUserByCriticId) {
		this.yiUserByCriticId = yiUserByCriticId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dongtai_id")
	public DongTai getYiDongtai() {
		return this.yiDongtai;
	}

	public void setYiDongtai(DongTai yiDongtai) {
		this.yiDongtai = yiDongtai;
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