package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtlib.dao.BorrowRecordMapper;
import com.wtlib.pojo.BorrowRecord;
import com.wtlib.service.BorrowRecordService;

/**
 * @author pohoulong
 * @date 2017年1月22日 下午2:03:18
 */
@Service("borrowRecordService")
public class BorrowRecordServiceImpl implements BorrowRecordService {

	@Autowired
	BorrowRecordMapper borrowRecordMapper;
	@Override
	public int insert(BorrowRecord entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBatch(List<BorrowRecord> entityList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BorrowRecord selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BorrowRecord> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(BorrowRecord entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BorrowRecord find(Object str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BorrowRecord selectBySingleId(Integer singleId) {
		BorrowRecord record = borrowRecordMapper.selectBySingleId(singleId);
		return record;
	}

}