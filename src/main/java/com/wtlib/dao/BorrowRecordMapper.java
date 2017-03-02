package com.wtlib.dao;

import java.util.List;

import com.wtlib.pojo.BorrowRecord;

/**
 * @author zongzi
 * @date 2017年1月21日 下午6:17:13
 */
public interface BorrowRecordMapper extends BaseDao<BorrowRecord> {

	Integer findRecord(BorrowRecord record);

	BorrowRecord selectBySingleId(Integer singleId);

	List<BorrowRecord> selectAllByUserId(Object id, String code);
	
}