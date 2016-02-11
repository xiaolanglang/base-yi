package com.yilv.base.sys.security;

import com.yilv.base.common.utils.StringUtils;

/**
 * 用户和密码（包含验证码）令牌类
 * 
 * @author ThinkGem
 * @version 2013-5-19
 */
public class UsernamePasswordToken extends org.apache.shiro.authc.UsernamePasswordToken {

	private static final long serialVersionUID = 1L;

	private String captcha;
	private boolean mobileLogin;

	public UsernamePasswordToken() {
		super();
	}

	public UsernamePasswordToken(String username, String password) {
		super(username, password);
		this.mobileLogin = true;
	}

	public UsernamePasswordToken(String username, char[] password, boolean rememberMe, String host, String captcha,
			boolean mobileLogin) {
		super(username, password, rememberMe, host);
		this.captcha = captcha;
		this.mobileLogin = mobileLogin;
	}

	public String getCaptcha() {
		return captcha;
	}

	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}

	public boolean isMobileLogin() {
		return mobileLogin;
	}

	@Override
	public String getUsername() {
		String username = super.getUsername();
		if (StringUtils.isEmpty(username)) {
			return "";
		}
		return username;
	}

}