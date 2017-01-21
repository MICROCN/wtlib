package com.wtlib.dao;

import com.wtlib.pojo.BookBase;

public interface BookBaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookBase record);

    int insertSelective(BookBase record);

    BookBase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookBase record);

    int updateByPrimaryKey(BookBase record);
}