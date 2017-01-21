package com.wtlib.dao;

import com.wtlib.pojo.CreditInfo;

public interface CreditInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CreditInfo record);

    int insertSelective(CreditInfo record);

    CreditInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(CreditInfo record);

    int updateByPrimaryKey(CreditInfo record);
}