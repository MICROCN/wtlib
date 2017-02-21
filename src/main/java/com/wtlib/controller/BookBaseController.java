package com.wtlib.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.wtlib.constants.Code;
import com.wtlib.dto.UserWebDto;
import com.wtlib.pojo.BookBase;
import com.wtlib.pojo.User;
import com.wtlib.service.BookBaseService;

/**
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午2:26:54
 */
@Controller
@RequestMapping("/bookbase")
public class BookBaseController {
	@Autowired
	private BookBaseService baseService;
	
	Logger log = Logger.getLogger(BookBaseController.class);
	
	@RequestMapping("/add")
	public Message addBook(@RequestBody BookBase book,HttpSession session){
		//这里只列举了几个重要的进行判断。比如图书描述、图书价格等没有强制要求（当当网也是没有强制要求）
		String title= book.getBookTitle();
		String url= book.getBookCoverUrl();
		String writer= book.getBookWriter();
		String publicsher = book.getBookPublisher();
		if(title==null){
			return Message.error(Code.PARAMATER, "书名不得为空！");
		}
		if(url==null){
			return Message.error(Code.PARAMATER, "图片地址不得为空！");
		}
		if(writer==null){
			return Message.error(Code.PARAMATER, "作者不得为空！");
		}
		if(publicsher==null){
			return Message.error(Code.PARAMATER, "出版商不得为空！");
		}
		String id = session.getAttribute("id").toString();// 以后会改
		book.setCreator(new Integer(id));
		book.setBook_num(0);
		try {
			baseService.insert(book);
		} catch (Exception e) {
			log.error(JSON.toJSONString(book) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法添加数据");
		}
		return Message.success("添加成功");
	}
	
	@RequestMapping("/delete")
	public Message deleteBook(@RequestParam("id") Integer id){
		try {
			baseService.deleteById(id);
			return Message.success("删除成功");
		} catch (Exception e) {
			log.error(JSON.toJSONString(id) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法删除数据");
		}
	}
	
	@RequestMapping("/update")
	public Message updateBook(@RequestBody BookBase book,HttpSession session){
		String title= book.getBookTitle();
		String url= book.getBookCoverUrl();
		String writer= book.getBookWriter();
		String publicsher = book.getBookPublisher();
		if(title==null){
			return Message.error(Code.PARAMATER, "书名不得为空！");
		}
		if(url==null){
			return Message.error(Code.PARAMATER, "图片地址不得为空！");
		}
		if(writer==null){
			return Message.error(Code.PARAMATER, "作者不得为空！");
		}
		if(publicsher==null){
			return Message.error(Code.PARAMATER, "出版商不得为空！");
		}
		try {
			baseService.update(book);
			return Message.success("更新成功");
		} catch (Exception e) {
			log.error(JSON.toJSONString(book) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法更新数据");
		}
	}
	
	@RequestMapping("/find")
	public Message findBook(@RequestBody BookBase book) {
		String title = book.getBookTitle();
		if (title == null) {
			return Message.error(Code.PARAMATER, "书名为空");
		}
		try {
			List<BookBase> bookList = baseService.find(title);
			return Message.success(Code.SUCCESS, "查找成功", bookList);
		} catch (Exception e) {
			log.error(JSON.toJSONString(book) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到此书籍！");
		}
	}
	
	@RequestMapping("/get")
	public Message getBook() {
		try {
			List<BookBase> bookList = baseService.selectAll();
			return Message.success(Code.SUCCESS, "查找成功", bookList);
		} catch (Exception e) {
			log.error(e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到书籍！");
		}
	}
	
}
