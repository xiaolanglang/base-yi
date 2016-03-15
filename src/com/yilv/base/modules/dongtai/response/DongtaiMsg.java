package com.yilv.base.modules.dongtai.response;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.yilv.base.common.entity.BaseEntity;
import com.yilv.base.modules.account.entity.Account;

public class DongtaiMsg extends BaseEntity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 用户信息
	private Account account;
	// 动态信息
	private String content;
	private Date createTime;
	private String position;
	private int attitudesCount;
	private int commentCount;
	private String isGood;
	private List<String> imageUrls;

	public DongtaiMsg() {
	}

	public DongtaiMsg(Account account) {
		this.account = account;
	}

	public int getAttitudesCount() {
		return attitudesCount;
	}

	public void setAttitudesCount(int attitudesCount) {
		this.attitudesCount = attitudesCount;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List<String> getImageUrls() {
		return imageUrls;
	}

	public void setImageUrls(List<String> imageUrls) {
		this.imageUrls = imageUrls;
	}

	@DateTimeFormat(pattern = "yyyy-MM-dd hh:mm")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}

	public String getIsGood() {
		return isGood;
	}

	public void setIsGood(String isGood) {
		this.isGood = isGood;
	}

}
