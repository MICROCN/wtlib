package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wtlib.pojo.BookReservation;
import com.wtlib.service.BookReservationService;

/**
 * @Description: 图书预约类
 * @author zongzi
 * @date 2017年1月22日 下午1:56:32
 */
@Service("bookReservationService")
public class BookReservationServiceImpl implements BookReservationService {

	@Override
	public int insert(BookReservation entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBatch(List<BookReservation> entityList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookReservation selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookReservation> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BookReservation entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
