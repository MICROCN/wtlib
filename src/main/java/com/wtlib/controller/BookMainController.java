package com.wtlib.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Message;
import com.alibaba.fastjson.JSON;
import com.wtlib.constants.Code;
import com.wtlib.pojo.BookBase;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.pojo.BookSingle;
import com.wtlib.service.BookBaseService;
import com.wtlib.service.BookBaseSupportService;
import com.wtlib.service.BookSingleService;
import com.wtlib.service.serviceImpl.BookReservationServiceImpl;
import com.wtlib.util.IpUtils;

public class BookMainController {
	
	@Resource(name = "/bookBaseSupportServiceImpl")
	BookBaseSupportService BaseSupportService;
	
	@Resource(name = "/bookBaseService")
	private BookBaseService baseService;
	
	@Resource(name = "bookReservationService")
	private BookReservationServiceImpl reservationService;
	
	@Resource(name = "bookSingleService")
	private BookSingleService singleService;
	
	Logger log = Logger.getLogger(BookMainController.class);
	//BookBase
	@RequestMapping("/add/book")
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
		book.setBookNum(0);
		try {
			baseService.insert(book);
		} catch (Exception e) {
			log.error(JSON.toJSONString(book) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法添加数据");
		}
		return Message.success("添加成功");
	}
	
	@RequestMapping("/delete/book")
	public Message deleteBook(@RequestParam("id") Integer id){
		//传入的是singleid。
		try { 
			baseService.deleteById(id);
			return Message.success("删除成功");
		} catch (Exception e) {
			log.error(JSON.toJSONString(id) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法删除数据");
		}
	}
	
	@RequestMapping("/delete/allbook")
	public Message deleteAllBook(@RequestParam("id") Integer id){
		//传入的是base_id。
		try {
			baseService.deleteByBaseId(id);
			return Message.success("删除成功");
		} catch (Exception e) {
			log.error(JSON.toJSONString(id) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法删除数据");
		}
	}
	
	@RequestMapping("/update/book")
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
		String id = session.getAttribute("id").toString();// 以后会改
		book.setReviser(new Integer(id));
		try {
			baseService.update(book);
			return Message.success("更新成功");
		} catch (Exception e) {
			log.error(JSON.toJSONString(book) + "\n\t" + e.toString());
			return Message.error(Code.ERROR_CONNECTION, "无法更新数据");
		}
	}
	
	@RequestMapping("/find/book")
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
	
	@RequestMapping("/get/book")
	public Message getBook() {
		try {
			List<BookBase> bookList = baseService.selectAll();
			return Message.success(Code.SUCCESS, "查找成功", bookList);
		} catch (Exception e) {
			log.error(e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到书籍！");
		}
	}
	
	//bookbasesupport
	@RequestMapping("/get/support")
	public Message getBook(@RequestParam("id") Integer id) {
		//传入的是baseid
		try {
			BookBaseSupport book = BaseSupportService.selectByBaseId(id);
			return Message.success(Code.SUCCESS, "查找成功", book);
		} catch (Exception e) {
			log.error("id:"+id+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到书籍！");
		}
	}
	
	//BookBorrow
	@RequestMapping("/update/borrow")
	public Message borrow(List<BookSingle> bookList,HttpSession session,HttpServletRequest request){
		String id = session.getAttribute("id").toString();// 以后会改
		for(BookSingle book : bookList){
			book.setReviser(new Integer(id));
			String hash = book.getBookHash();
			book.setCurrentOwner(new Integer(id));
			book.setReviser(new Integer(id));
			if(hash!=null){
				//恶意侵入，记录ip，并禁止其再次登录
				String ip= IpUtils.getIp(request);
				log.error("ip:"+JSON.toJSON(ip)+"\n\t");
				return Message.error(Code.FATAL_ERROR, "别搞事情",ip);
			}
			try {
				singleService.update(book);
			} catch (Exception e) {
				log.error("book:"+JSON.toJSONString(book)+"\n\t"+e.toString());
				return Message.error(Code.ERROR_CONNECTION, "找不到书籍！");
			}
		}
		return Message.success("借阅成功");
	}
	
	@RequestMapping("/update/back/{hash}")
	public Message back(@PathVariable String hash,HttpSession session){
		String id = session.getAttribute("id").toString();// 以后会改
		BookSingle single = new BookSingle(hash,new Integer(id));
		try {
			singleService.editReturnBack(single);
			return Message.success("归还成功");
		} catch (Exception e) {
			log.error("book:"+JSON.toJSONString(hash)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "找不到书籍！");
		}
	}
	
	@RequestMapping("/update/reservation")
	public Message reservation(@RequestParam("id") Integer id, HttpSession session){
		String userId = session.getAttribute("id").toString();// 以后会改
		try {
			reservationService.insertNewBookReservation(id, new Integer(userId));
			return Message.success("借阅成功");
		} catch (Exception e) {
			log.error("book:"+JSON.toJSONString(id)+"\n\t"+e.toString());
			return Message.error(Code.ERROR_CONNECTION, "借阅失败！");
		}
	}
}
