package com.yilv.base.modules.dongtai.response;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.yilv.base.common.entity.BaseEntity;
import com.yilv.base.modules.account.entity.Account;

public class DongtaiMsg extends BaseEntity<DongtaiMsg> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 用户信息
	private Account account;
	// 动态信息
	private String content;
	private String createTime;
	private String position;
	private String attitudesCount;
	private List<String> imageUrls;

	public DongtaiMsg() {
	}

	public DongtaiMsg(Account account) {
		this.account = account;
	}

	@Column(name = "attitudesCount")
	public String getAttitudesCount() {
		return attitudesCount;
	}

	public void setAttitudesCount(String attitudesCount) {
		this.attitudesCount = attitudesCount;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "account")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Column(name = "content", length = 120)
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Column(name = "position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Transient
	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "create_time", nullable = false, length = 19)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

}
