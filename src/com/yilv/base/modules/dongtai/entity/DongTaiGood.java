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
	private Account yiUserByOwner;
	private DongTai yiDongtai;
	private Account yiUserByUserid;

	// Constructors

	/** default constructor */
	public DongTaiGood() {
	}

	/** full constructor */
	public DongTaiGood(Account yiUserByOwner, DongTai yiDongtai, Account yiUserByUserid) {
		this.yiUserByOwner = yiUserByOwner;
		this.yiDongtai = yiDongtai;
		this.yiUserByUserid = yiUserByUserid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	public Account getYiUserByOwner() {
		return this.yiUserByOwner;
	}

	public void setYiUserByOwner(Account yiUserByOwner) {
		this.yiUserByOwner = yiUserByOwner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dongtaiId")
	public DongTai getYiDongtai() {
		return this.yiDongtai;
	}

	public void setYiDongtai(DongTai yiDongtai) {
		this.yiDongtai = yiDongtai;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userid")
	public Account getYiUserByUserid() {
		return this.yiUserByUserid;
	}

	public void setYiUserByUserid(Account yiUserByUserid) {
		this.yiUserByUserid = yiUserByUserid;
	}

}