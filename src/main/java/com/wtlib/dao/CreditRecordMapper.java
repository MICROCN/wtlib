package com.wtlib.dao;

import com.wtlib.pojo.CreditRecord;

public interface CreditRecordMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditRecord record);

    int insertSelective(CreditRecord record);

    CreditRecord selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditRecord record);

    int updateByPrimaryKey(CreditRecord record);
}