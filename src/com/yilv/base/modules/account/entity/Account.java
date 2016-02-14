package com.yilv.base.modules.account.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

import com.yilv.base.common.entity.DataEntity;

@Entity
@Table(name = "yi_account")
public class Account extends DataEntity<Account> {

	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	private String nickname;
	private String phone;
	private String bad;
	private String img;

	// Constructors

	/** default constructor */
	public Account() {
	}

	public Account(String id) {
		this.id = id;
	}

	public Account(String username, String id) {
		this.id = id;
		this.username = username;
	}

	@Column(name = "username", length = 20)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "password", length = 32)
	@Length(min = 6, message = "密码长度不能小于6位")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "nickname", length = 10)
	@Length(max = 10, message = "昵称最大不能超过10个汉字")
	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	@Column(name = "phone", length = 11)
	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Column(name = "bad", length = 1)
	public String getBad() {
		return this.bad;
	}

	public void setBad(String bad) {
		this.bad = bad;
	}

	@Column(name = "img")
	public String getImg() {
		return this.img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}