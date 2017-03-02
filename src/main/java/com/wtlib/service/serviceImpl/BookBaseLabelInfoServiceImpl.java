package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtlib.dao.BookBaseLabelInfoMapper;
import com.wtlib.pojo.BookBaseLabelInfo;
import com.wtlib.service.BookBaseLabelInfoService;

@Service("bookBaseLabelInfoService")
public class BookBaseLabelInfoServiceImpl implements BookBaseLabelInfoService {

	@Autowired
	private BookBaseLabelInfoMapper bookBaseLabelInfoMapper;

	@Override
	public int insert(BookBaseLabelInfo entity) throws Exception {
		Integer num = bookBaseLabelInfoMapper.insert(entity);
		return num;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBatch(List<BookBaseLabelInfo> entityList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookBaseLabelInfo selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookBaseLabelInfo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(BookBaseLabelInfo entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BookBaseLabelInfo find(Object str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByLabelId(int labelId) {
		// TODO Auto-generated method stub

	}

}
