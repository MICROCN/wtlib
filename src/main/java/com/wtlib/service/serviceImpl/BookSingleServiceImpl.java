package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.dao.BookBaseSupportMapper;
import com.wtlib.dao.BookSingleMapper;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.pojo.BookSingle;
import com.wtlib.service.BookSingleService;

/**
 * @author zongzi
 * @date 2017年1月22日 下午2:01:00
 */
@Service("bookSingleService")
public class BookSingleServiceImpl implements BookSingleService {

	@Autowired
	BookSingleMapper bookSingleMapper;
	@Autowired
	BookBaseSupportMapper bookBaseSupportMapper;
	
	@Override
	public int insert(BookSingle entity) throws Exception {
		Integer num= bookSingleMapper.insert(entity);
		return num;
	}
	
	@Override
	public int deleteById(Object id) throws Exception {
		Integer num= bookSingleMapper.deleteById(id);
		return num;
	}
	
	@Override
	public int update(BookSingle entity) throws Exception {
		Integer id = entity.getBookBaseId();
		BookBaseSupport support = bookBaseSupportMapper.selectById(id);
		Integer book= support.getCurrentLeftBookNumber()-1;
		Assert.isTrue(book>=0,"无法借阅书！");
		if(book==0){
			support.setCurrentLeftBookNumber(0);
			support.setIsBorrowAble("0");
			support.setIsReservateAble("1");
		}
		else{
			support.setCurrentLeftBookNumber(book);
		}
		Integer num = bookSingleMapper.update(entity);
		bookBaseSupportMapper.update(support);
		return num;
	}

	@Override
	public int insertBatch(List<BookSingle> entityList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookSingle selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookSingle> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookSingle find(Object str) {
		// TODO Auto-generated method stub
		return null;
	}

}
