package com.wtlib.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.Message;
import com.wtlib.constants.Code;
import com.wtlib.constants.CommonConstant;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;

/**
 * @author pohoulong
 * 
 */
@Controller
public class LoginController extends BaseController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public Message login(@RequestBody User user) {
		String password = user.getPassword();
		String loginId = user.getLoginId();
		if(password==null){
			return Message.error(Code.PARAMATER, "不得为空");
		}
		if(password.matches("^.*[\\s]+.*$")){
			return Message.error(Code.PARAMATER, "密码不能包含空格、制表符、换页符等空白字符");
		}
		
		return null;
	}
}
