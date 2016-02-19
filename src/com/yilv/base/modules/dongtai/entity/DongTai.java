package com.yilv.base.modules.dongtai.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.yilv.base.common.entity.DataEntity;

/**
 * YiDongtai entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "yi_dongtai")
public class DongTai extends DataEntity<DongTai> {

	private static final long serialVersionUID = 1L;
	private String content;
	private String range;
	private String position;

	// Constructors

	/** default constructor */
	public DongTai() {
	}

	@Column(name = "content", length = 120)
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "range_show")
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