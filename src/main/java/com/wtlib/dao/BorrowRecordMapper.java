package com.wtlib.dao;

import com.wtlib.pojo.BorrowRecord;

public interface BorrowRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BorrowRecord record);

    int insertSelective(BorrowRecord record);

    BorrowRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BorrowRecord record);

    int updateByPrimaryKey(BorrowRecord record);
}