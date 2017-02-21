package com.wtlib.service.serviceImpl;


import java.util.List;










import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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
		Integer id= bookBaseMapper.insert(entity);
		Integer num= entity.getBook_num();
		BookBaseSupport support = new BookBaseSupport(id, "1" , "1", num, 0, num);
		bookBaseSupportMapper.insert(support);
		for(int i =0; i<num; i++){
			BookSingle bookSingle = new BookSingle(id,"id"+UUID.randomUUID());
			bookSingleMapper.insert(bookSingle);
		}
		return id;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		int num=bookBaseMapper.deleteById(id);
		bookBaseSupportMapper.deleteById(id);
		bookSingleMapper.deleteById(id);
		return num;
	}
	
	@Override
	public int update(BookBase entity) throws Exception {
		int num= entity.getBook_num();
		Integer id= bookBaseMapper.update(entity);
		BookBaseSupport support = new BookBaseSupport(id, num);
		bookBaseSupportMapper.update(support);
		return id;
	}

	
	@Override
	public List<BookBase> find(String title) {
		List bookBase =bookBaseMapper.findByTitle(title);
		Assert.isTrue(bookBase!=null,"查询不到此书！");
		return null;
	}

	@Override
	public List<BookBase> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return null;
	}

}
