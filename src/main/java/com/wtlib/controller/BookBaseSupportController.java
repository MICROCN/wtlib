package com.wtlib.controller;

import java.io.Reader;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Message;
import com.wtlib.constants.Code;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.service.BookBaseSupportService;

@Controller
@RequestMapping("/bookbasesupport")
public class BookBaseSupportController {
	
	@Resource(name = "/bookBaseSupportServiceImpl")
	BookBaseSupportService BaseSupportServiceImpl;
	
	Logger log = Logger.getLogger(BookBaseController.class);
	
	@RequestMapping("/get")
	public Message getBook(@RequestParam("id") Integer id) {
		try {
			BookBaseSupport book = BaseSupportServiceImpl.selectById(id);
			return Message.success(Code.SUCCESS, "查找成功", book);
		} catch (Exception e) {
			log.error("id:"+id+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到书籍！");
		}
	}
}
