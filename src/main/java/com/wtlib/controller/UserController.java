package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wtlib.pojo.User;
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
	
	@RequestMapping("save")
	public @ResponseBody
	String save() {
		User user = new User("tinys", "123456", "0");
		userService.save(user);
		return "save ok";
	}

	@RequestMapping("update")
	public @ResponseBody
	String update() {
		User user = new User("tinys", "123456", "1");
		userService.update(user);
		return "update ok";
	}

	@RequestMapping("delete")
	public @ResponseBody
	String delete() {
		userService.delete("tinys");
		return "delete ok";
	}

	@RequestMapping("find")
	public @ResponseBody
	String find() {
		User user = userService.find("tinys");
		return user.getName() + user.getPwd() + user.getRole();
	}
}
