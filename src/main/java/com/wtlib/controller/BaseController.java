<<<<<<< HEAD
package com.wtlib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import com.wtlib.constants.CommonConstant;
import com.wtlib.pojo.User;

public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";

	/**
	 * @return
	 */
	public static User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}

	public static void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}

	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "路径必须使用/开头");
		return request.getContextPath() + url;
	}
}
=======
package com.wtlib.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.util.Assert;

import com.wtlib.constants.CommonConstant;
import com.wtlib.pojo.User;

public class BaseController {
	protected static final String ERROR_MSG_KEY = "errorMsg";

	/**
	 * @return
	 */
	public static User getSessionUser(HttpServletRequest request) {
		return (User) request.getSession().getAttribute(
				CommonConstant.USER_CONTEXT);
	}

	public static void setSessionUser(HttpServletRequest request, User user) {
		request.getSession().setAttribute(CommonConstant.USER_CONTEXT, user);
	}

	public final String getAppbaseUrl(HttpServletRequest request, String url) {
		Assert.hasLength(url, "url不能为空");
		Assert.isTrue(url.startsWith("/"), "路径必须使用/开头");
		return request.getContextPath() + url;
	}
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
