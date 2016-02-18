package com.yilv.base.sys.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Service;

import com.yilv.base.common.utils.StringUtils;

/**
 * 表单验证（包含验证码）过滤类
 * 
 * @author ThinkGem
 * @version 2014-5-19
 */
@Service
public class FormAuthenticationFilter extends org.apache.shiro.web.filter.authc.FormAuthenticationFilter {

	public static final String DEFAULT_CAPTCHA_PARAM = "validateCode";
	public static final String DEFAULT_MOBILE_PARAM = "mobileLogin";
	public static final String DEFAULT_MESSAGE_PARAM = "message";

	private String captchaParam = DEFAULT_CAPTCHA_PARAM;
	private String mobileLoginParam = DEFAULT_MOBILE_PARAM;
	private String messageParam = DEFAULT_MESSAGE_PARAM;

	protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
		String username = getUsername(request);
		String password = getPassword(request);
		if (password == null) {
			password = "";
		}
		// boolean rememberMe = isRememberMe(request);
		// 手机端登录默认记住用户
		boolean rememberMe = true;
		String host = StringUtils.getRemoteAddr((HttpServletRequest) request);
		String captcha = getCaptcha(request);
		boolean mobile = isMobileLogin(request);

		Object returnUrl = request.getAttribute("returnUrl");
		if (returnUrl != null && !StringUtils.isEmpty(returnUrl.toString())) {
			// TODO 如果不为空就说明要跳转到指定的页面，否则就跳转到主页面
			setSuccessUrl(returnUrl.toString());
		}
		return new UsernamePasswordToken(username, password.toCharArray(), rememberMe, host, captcha, mobile);
	}

	public String getCaptchaParam() {
		return captchaParam;
	}

	protected String getCaptcha(ServletRequest request) {
		return WebUtils.getCleanParam(request, getCaptchaParam());
	}

	public String getMobileLoginParam() {
		return mobileLoginParam;
	}

	protected boolean isMobileLogin(ServletRequest request) {
		return WebUtils.isTrue(request, getMobileLoginParam());
	}

	public String getMessageParam() {
		return messageParam;
	}

	protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
		request.setAttribute(getFailureKeyAttribute(), ae.getClass().getName());
		if (ae.getMessage() != null && StringUtils.startsWith(ae.getMessage(), "msg:")) {
			String message = StringUtils.replace(ae.getMessage(), "msg:", "");
			request.setAttribute(getMessageParam(), message);
		}
	}

	/**
	 * 登录成功之后跳转URL
	 */
	public String getSuccessUrl() {
		return super.getSuccessUrl();
	}

	@Override
	protected void issueSuccessRedirect(ServletRequest request, ServletResponse response) throws Exception {
		// Principal p = UserUtils.getPrincipal();
		// if (p != null && !p.isMobileLogin()){
		WebUtils.issueRedirect(request, response, getSuccessUrl(), null, true);
		// }else{
		// super.issueSuccessRedirect(request, response);
		// }
	}
}