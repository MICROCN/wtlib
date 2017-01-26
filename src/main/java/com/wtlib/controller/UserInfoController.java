package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.UserInfoService;


/**
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午2:46:21
 */
@Controller
@RequestMapping("/userinfo")
public class UserInfoController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping("/test")
	public String test(){
		System.out.println("in");
		return "/user/index";
	}
}
