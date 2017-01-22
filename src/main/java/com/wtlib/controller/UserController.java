package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.UserService;

/**
 * ClassName: UserController
 * 
 * @Description: 简单的Action的controller..实现了增删改查..
 * @author dapengniao
 * @date 2016年6月25日 下午1:18:29
 */
@Controller
@RequestMapping("/user/")
public class UserController {
	
	@Autowired UserService userService;
	
}