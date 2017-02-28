package com.wtlib.service.serviceImpl;


import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.constants.StatusEnum;
import com.wtlib.dao.BookBaseMapper;
import com.wtlib.dao.BookBaseSupportMapper;
import com.wtlib.dao.BookSingleMapper;
import com.wtlib.pojo.BookBase;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.pojo.BookSingle;
import com.wtlib.service.BookBaseService;

/**
 * @Description: 基础图书处理类
 * @author pohoulong
 * @date 2017年1月22日 下午1:55:48
 */
@Service("bookBaseService")
public class BookBaseServiceImpl implements BookBaseService {

	@Autowired
	BookBaseMapper bookBaseMapper;
	@Autowired
	BookBaseSupportMapper bookBaseSupportMapper;
	@Autowired
	BookSingleMapper bookSingleMapper;
	
	@Override
	public int insert(BookBase entity) throws Exception {
		//插入bookBase表返回bookBase对象，如果没有同类书籍的话自然String是null，所以不用判断他是否存在
		BookBase book = bookBaseMapper.find(entity);
		Integer num= entity.getBookNum();
		Integer id = book.getId();
		Integer person = entity.getCreator();
		BookBaseSupport support;
		if(id != null){
			Integer currentNum = book.getBookNum()+num;
			book.setBookNum(currentNum);
			book.setReviser(person);
			bookBaseMapper.update(book);
			//判断,插入bookBaseSupport
			support = bookBaseSupportMapper.selectBookBaseSupportByBookBaseId(id,StatusEnum.COMMONUSE.getCode());
			support.setSingleBookNumber(currentNum);
			Integer currentLeftBook = support.getCurrentLeftBookNumber()+num;
			support.setCurrentLeftBookNumber(currentLeftBook);
			support.setReviser(person);
			Integer reservation = support.getCurrentReservateNumber();
			support.setIsBorrowAble("1");
			//如果里面还有人预约，即图书原来现存量是0，则通知他们可以借书了。
			if(reservation!=null){
				//TODO 通知预约者可以借书了
			}
			bookBaseSupportMapper.update(support);
		} else{
			//如果查找不到即没有此类书籍。
			entity.setStartDate("001");
			id = bookBaseMapper.insert(entity);
			support = new BookBaseSupport(id, "0" , "1", num, 0, num);
			support.setStartDate("001");
			support.setCreator(person);	
			bookBaseSupportMapper.insert(support);
		}
		for(int i =0; i<num; i++){
			BookSingle bookSingle = new BookSingle(id,"id"+UUID.randomUUID());
			bookSingle.setCreator(person);
			bookSingleMapper.insert(bookSingle);
		}
		return id;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		//update booksingleMapper通过singleMap找到bookBaseid
		int num=bookSingleMapper.deleteById(id);
		BookSingle single = bookSingleMapper.findById(id);
		Integer baseId = single.getBookBaseId();
	 	BookBaseSupport support = bookBaseSupportMapper.selectBookBaseSupportByBookBaseId(baseId,StatusEnum.COMMONUSE.getCode());
		Integer singleBookNum = support.getSingleBookNumber();
		if(singleBookNum==0)
			deleteByBaseId(baseId);
		else
			support.setSingleBookNumber(singleBookNum);
	 	Integer currentBookNum = support.getCurrentLeftBookNumber() - 1;
	 	if(currentBookNum == 0){
	 		support.setIsReservateAble("1");
	 		support.setIsBorrowAble("0");
	 	}
	 	support.setCurrentLeftBookNumber(currentBookNum);
		bookBaseSupportMapper.update(support);
		BookBase base = new BookBase();
		base.setBookNum(singleBookNum);
		base.setId(baseId);
		bookBaseMapper.update(base);
		return num;
	}
	
	@Override
	public void deleteByBaseId(Integer id) throws Exception {
		bookBaseMapper.deleteById(id);
	}
	
	@Override
	public int update(BookBase entity) throws Exception {
		Integer id= bookBaseMapper.update(entity);
		return id;
	}

	
	@Override
	public List<BookBase> find(String title) {
		List<BookBase> bookBaseList =bookBaseMapper.findByTitle(title);
		return bookBaseList;
	}

	@Override
	public List<BookBase> selectAll() throws Exception {
		List<BookBase> bookBaseList =bookBaseMapper.selectAll();
		return bookBaseList;
	}
	
	@Override
	public BookBase selectById(Object id) throws Exception {
		return null;
	}

	
	@Override
	public int insertBatch(List<BookBase> entityList) throws Exception {
		return 0;
	}

	@Override
	public BookBase find(Object str) {
		return null;
	}


}
