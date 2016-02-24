package com.yilv.base.modules.dongtai.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.yilv.base.common.entity.DataEntity;
import com.yilv.base.modules.account.entity.Account;

/**
 * YiDontaiGood entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "yi_dongtai_good")
public class DongTaiGood extends DataEntity<DongTaiGood> {

	private static final long serialVersionUID = 1L;
	private Account user;
	private DongTai dongTai;

	// Constructors

	/** default constructor */
	public DongTaiGood() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user")
	public Account getUser() {
		return user;
	}

	public void setUser(Account user) {
		this.user = user;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dongtaiId")
	public DongTai getDongTai() {
		return dongTai;
	}

	public void setDongTai(DongTai dongTai) {
		this.dongTai = dongTai;
	}

}