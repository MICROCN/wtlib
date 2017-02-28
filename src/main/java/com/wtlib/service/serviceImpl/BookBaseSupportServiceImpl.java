package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.constants.DataStatusEnum;
import com.wtlib.constants.StatusEnum;
import com.wtlib.dao.BookBaseSupportMapper;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.service.BookBaseSupportService;

@Service("/bookBaseSupportServiceImpl")
public class BookBaseSupportServiceImpl implements BookBaseSupportService{

	@Autowired
	BookBaseSupportMapper baseSupportMapper;
	
	@Override
	public BookBaseSupport selectByBaseId(Integer id) throws Exception {
		BookBaseSupport book = baseSupportMapper.selectBookBaseSupportByBookBaseId(id,DataStatusEnum.NORMAL_USED.getCode());
		Assert.isTrue(book!=null,"查不到此书籍");
		return book;
	}
	
	@Override
	public int deleteById(Object id) throws Exception {
		Integer num = baseSupportMapper.deleteById(id);
		return num;
	}

	@Override
	public int update(BookBaseSupport entity) throws Exception {
		Integer num = baseSupportMapper.update(entity);
		return num;
	}
	
	
	@Override
	public int insert(BookBaseSupport entity) throws Exception {
		Integer num = baseSupportMapper.insert(entity);
		return num;
	}

	@Override
	public int insertBatch(List<BookBaseSupport> entityList) throws Exception {
		return 0;
	}


	@Override
	public List<BookBaseSupport> selectAll() throws Exception {
		return null;
	}


	@Override
	public BookBaseSupport find(Object str) {
		return null;
	}

	@Override
	public BookBaseSupport selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
}
