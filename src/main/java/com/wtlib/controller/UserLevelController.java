package com.wtlib.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO
 * @author pohoulong
 * @date 2017年1月22日 下午2:48:23
 */
@Controller
@RequestMapping("/userlevel")
public class UserLevelController {
	@Resource(name= "userLevelService")
	private UserLevelService uerLevelService;

	Logger log = Logger.getLogger(UserController.class);
	
	@RequestMapping("/add")
	@ResponseBody
	public Message addUser(@RequestBody UserInfo userInfo,HttpSession session){
		String id= session.getAttribute("id").toString();//以后会改
		userInfo.setCreator(new Integer(id));
		String username = userInfo.getUsername();
		if(username==null){
			return Message.error(Code.PARAMATER, "不得为空");
		}
		if(username.matches("^.*[\\s]+.*$")){
			return Message.error(Code.PARAMATER, "昵称不能包含空格、制表符、换页符等空白字符");
		}
		try {
			userInfoService.insert(userInfo);
			return Message.success("插入成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(userInfo)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteUser(@RequestParam("id") Integer id){
		try {
			userInfoService.deleteById(id);
			return Message.success("删除成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(id)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Message updateUser(@RequestBody UserInfo userInfo,HttpSession session){
		String username = userInfo.getUsername();
		if(username==null){
			return Message.error(Code.PARAMATER, "不得为空");
		}
		String id= session.getAttribute("id").toString();//以后会改
		try {
			userInfo.setReviser(new Integer(id));
			userInfoService.update(userInfo);
			return Message.success("更新成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(userInfo)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		}
	}
	
	@RequestMapping("/find")
	@ResponseBody
	public Message findUser(@RequestBody UserInfo userInfo){
		String username = userInfo.getUsername();
		if(username== null){
			return Message.error(Code.PARAMATER, "不得为空");
		}
		try {
			UserWebDto dto = userInfoService.find(username);
			return Message.success("删除成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(userInfo)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		} 
	}
	
	
}
