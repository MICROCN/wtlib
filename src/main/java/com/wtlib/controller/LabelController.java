package com.wtlib.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.wtlib.constants.Code;
import com.wtlib.pojo.LabelInfo;
import com.wtlib.service.LabelInfoService;

public class LabelController {

	@Autowired
	private LabelInfoService labelInfoService;
	
	Logger log = Logger.getLogger(LabelController.class);
	
	//user
	@RequestMapping("/add")
	@ResponseBody
	public Message addFeedBack(@RequestBody LabelInfo info, HttpSession session) {
		String id = session.getAttribute("id").toString();// 以后会改
	    String value = info.getValue();
		if (value == null) {
			return Message.error(Code.PARAMATER, "不得为空");
		}
		info.setCreator(new Integer(id));
		info.setUserId(new Integer(id));
		try {	
			labelInfoService.insert(info);
			return Message.success("插入成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(info) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法插入数据");
		}
	}

	@RequestMapping("/delete")
	@ResponseBody
	public Message deleteFeedBack(@RequestParam("id") Integer id) {
		try {
			labelInfoService.deleteById(id);
			return Message.success("删除成功", Code.SUCCESS);
		} catch (Exception e) {
			log.error(JSON.toJSONString(id) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法删除数据");
		}
	}


	@RequestMapping("/get")
	public Message getFeedBack() {
		try {
			List<LabelInfo>labelList= labelInfoService.selectAll();
			return Message.success(Code.SUCCESS, "查找成功",labelList);
		} catch (Exception e) {
			log.error(e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到记录！");
		}
	}
		
}
