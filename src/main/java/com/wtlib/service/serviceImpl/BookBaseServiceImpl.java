package com.wtlib.service.serviceImpl;


import java.util.List;



import org.springframework.stereotype.Service;

import com.wtlib.pojo.BookBase;
import com.wtlib.service.BookBaseService;

/**
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午1:55:48
 */
@Service("bookBaseService")
public class BookBaseServiceImpl implements BookBaseService {

	@Override
	public int insert(BookBase entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBatch(List<BookBase> entityList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookBase selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookBase> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookBase entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}