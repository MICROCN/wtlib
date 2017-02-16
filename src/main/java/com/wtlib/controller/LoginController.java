<<<<<<< HEAD
package com.wtlib.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wtlib.constants.CommonConstant;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;

/**
 * @author ed
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping("/doLogins")
	public String login(Model model, HttpServletRequest request, User user) {
		User dbUser = null;
		try {
			dbUser = userService.getUserByLoginId(user.getLoginId());
		} catch (Exception e) {

		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if (dbUser == null) {
			mav.addObject("errorMsg", "用户名不存在");
		} else {
			setSessionUser(request, dbUser);
			String toUrl = (String) request.getSession().getAttribute(
					CommonConstant.LOGIN_TO_URL);
			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);

			if (StringUtils.isEmpty(toUrl)) {
				toUrl = "/index.html";
				mav.setViewName("redirect:" + toUrl);
			}
			model.addAttribute("user", dbUser);
		}
		return "/component/home";
	}
}
=======
package com.wtlib.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wtlib.constants.CommonConstant;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;

/**
 * @author ed
 * 
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;

	@RequestMapping("/doLogins")
	public String login(Model model, HttpServletRequest request, User user) {
		User dbUser = null;
		try {
			dbUser = userService.getUserByLoginId(user.getLoginId());
		} catch (Exception e) {

		}
		ModelAndView mav = new ModelAndView();
		mav.setViewName("forward:/login.jsp");
		if (dbUser == null) {
			mav.addObject("errorMsg", "用户名不存在");
		} else {
			setSessionUser(request, dbUser);
			String toUrl = (String) request.getSession().getAttribute(
					CommonConstant.LOGIN_TO_URL);
			request.getSession().removeAttribute(CommonConstant.LOGIN_TO_URL);

			if (StringUtils.isEmpty(toUrl)) {
				toUrl = "/index.html";
				mav.setViewName("redirect:" + toUrl);
			}
			model.addAttribute("user", dbUser);
		}
		return "/component/home";
	}
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
