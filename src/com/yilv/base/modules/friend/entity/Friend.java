package com.yilv.base.modules.friend.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yilv.base.common.entity.DataEntity;
import com.yilv.base.modules.account.entity.Account;

@Entity
@Table(name = "yi_friend")
public class Friend extends DataEntity<Friend> {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account owner;
	private Account friend;
	private String mark;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "owner", nullable = false)
	@JsonIgnore
	public Account getOwner() {
		return owner;
	}

	public void setOwner(Account owner) {
		this.owner = owner;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "friend", nullable = false)
	public Account getFriend() {
		return friend;
	}

	public void setFriend(Account friend) {
		this.friend = friend;
	}

	@Column(name = "mark", length = 20)
	public String getMark() {
		return this.mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

}