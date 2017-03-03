package com.wtlib.service;

import java.util.List;

import com.wtlib.pojo.BorrowRecord;

/**
 * 
 * 借阅记录服务
 * @author ed
 *
 */
public interface BorrowRecordService extends BaseService<BorrowRecord> {

	BorrowRecord selectBySingleId(Integer singleId) throws Exception;

	List<BorrowRecord> selectAllByUserId(String id,String borrowCode,String dataStatus) throws Exception;


}
