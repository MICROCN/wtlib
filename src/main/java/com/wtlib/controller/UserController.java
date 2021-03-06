<<<<<<< HEAD
package com.wtlib.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.wtlib.constants.Code;
import com.wtlib.constants.DataStatusEnum;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;

/**
 * ClassName: UserController
 * 
 * @Description: 简单的User的controller..实现了增删改查..
 * @author pohoulong
 *
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired UserService userService;
	Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping("/add")
	@ResponseBody
	public Message addUser(@RequestBody User user,HttpSession session){
		String id= session.getAttribute("id").toString();//以后会改
		user.setCreator(Integer.parseInt(id));
		String password = user.getPassword();
		if(password==null){
			return Message.error(Code.PARAMATER, "不得为空");
		}
		if(password.matches("^.*[\\s]+.*$")){
			return Message.error(Code.PARAMATER, "密码不能包含空格、制表符、换页符等空白字符");
		}
		if((!password.contains("@"))&&(!password.matches("^[1]([0-9][0-9])[0-9]{8}$"))){
			return Message.error(Code.PARAMATER, "手机号码错误");
		}
		if(password.contains("@")&&password.matches("^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$")){
			return Message.error(Code.PARAMATER, "邮箱不正确");
		}
		try {
			userService.insert(user);
			return Message.success("插入成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(user)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteUser(@RequestParam("id") int id){
		try {
			userService.deleteById(id);
			return Message.success("删除成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(id)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		}
	}
=======
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
	
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
}