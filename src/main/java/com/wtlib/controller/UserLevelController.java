package com.wtlib.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.wtlib.constants.Code;
import com.wtlib.pojo.UserLevel;
import com.wtlib.service.UserLevelService;
import com.wtlib.util.IpUtils;

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
	public Message addLevel(@RequestBody UserLevel userLevel,HttpSession session,HttpServletRequest request){
		String id= session.getAttribute("id").toString();//以后会改
		userLevel.setCreator(new Integer(id));
		String name =userLevel.getLevelName();
		Integer value =userLevel.getLevelMinCreditValue();
		Double weight =userLevel.getLevelWeight();
		
		if(value!=null){
			//恶意侵入，记录ip，并禁止其再次登录
			String ip= IpUtils.getIp(request);
			log.error("ip:"+JSON.toJSON(ip)+"\n\t id："+id);
			return Message.error(Code.FATAL_ERROR, "别搞事情",ip);
		}
		if(name==null|| weight==null){
			return Message.error(Code.PARAMATER, "不得为空");
		}
		if(name.matches("^.*[\\s]+.*$")){
			return Message.error(Code.PARAMATER, "昵称不能包含空格、制表符、换页符等空白字符");
		}
		try {
			value = new Integer((int) (weight*1200));//value的只由weight算出来的。这里假定为1200
			uerLevelService.insert(userLevel);
			return Message.success("插入成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(userLevel)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		}
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteLevel(@RequestParam("id") Integer id){
		try {
			uerLevelService.deleteById(id);
			return Message.success("删除成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(id)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		}
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public Message updateLevel(@RequestBody UserLevel userLevel,HttpSession session,HttpServletRequest request){
		String name =userLevel.getLevelName();
		Integer value =userLevel.getLevelMinCreditValue();
		Double weight =userLevel.getLevelWeight();
		String id= session.getAttribute("id").toString();//以后会改
		
		if(value!=null){
			//恶意侵入，记录ip，并禁止其再次登录
			String ip= IpUtils.getIp(request);
			log.error("ip:"+JSON.toJSON(ip)+"\n\t id："+id);
			return Message.error(Code.FATAL_ERROR, "别搞事情",ip);
		}
		if(name==null|| weight==null){
			return Message.error(Code.PARAMATER, "不得为空");
		}
		if(name.matches("^.*[\\s]+.*$")){
			return Message.error(Code.PARAMATER, "昵称不能包含空格、制表符、换页符等空白字符");
		}
		try {
			userLevel.setReviser(new Integer(id));
			uerLevelService.update(userLevel);
			return Message.success("更新成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(userLevel)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法查询数据");
		}
	}
	
	
}
