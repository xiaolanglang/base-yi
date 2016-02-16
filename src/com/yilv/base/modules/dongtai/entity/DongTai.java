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
 * YiDongtai entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "yi_dongtai")
public class DongTai extends DataEntity<DongTai> {

	private static final long serialVersionUID = 1L;
	private Account yiUser;
	private String content;
	private String range;
	private String position;
	private String img1;
	private String img2;
	private String img3;
	private String img4;
	private String img5;
	private String img6;
	private String img7;
	private String img8;
	private String img9;

	// Constructors

	/** default constructor */
	public DongTai() {
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner")
	public Account getYiUser() {
		return this.yiUser;
	}

	public void setYiUser(Account yiUser) {
		this.yiUser = yiUser;
	}

	@Column(name = "content", length = 120)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "img1")
	public String getImg1() {
		return this.img1;
	}

	public void setImg1(String img1) {
		this.img1 = img1;
	}

	@Column(name = "img2")
	public String getImg2() {
		return this.img2;
	}

	public void setImg2(String img2) {
		this.img2 = img2;
	}

	@Column(name = "img3")
	public String getImg3() {
		return this.img3;
	}

	public void setImg3(String img3) {
		this.img3 = img3;
	}

	@Column(name = "img4")
	public String getImg4() {
		return this.img4;
	}

	public void setImg4(String img4) {
		this.img4 = img4;
	}

	@Column(name = "img5")
	public String getImg5() {
		return this.img5;
	}

	public void setImg5(String img5) {
		this.img5 = img5;
	}

	@Column(name = "img6")
	public String getImg6() {
		return this.img6;
	}

	public void setImg6(String img6) {
		this.img6 = img6;
	}

	@Column(name = "img7")
	public String getImg7() {
		return this.img7;
	}

	public void setImg7(String img7) {
		this.img7 = img7;
	}

	@Column(name = "img8")
	public String getImg8() {
		return this.img8;
	}

	public void setImg8(String img8) {
		this.img8 = img8;
	}

	@Column(name = "img9")
	public String getImg9() {
		return this.img9;
	}

	public void setImg9(String img9) {
		this.img9 = img9;
	}

	@Column(name = "range")
	public String getRange() {
		return range;
	}

	public void setRange(String range) {
		this.range = range;
	}

	@Column(name = "position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

}