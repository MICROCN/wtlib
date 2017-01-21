package com.wtlib.dao;

import com.wtlib.pojo.BookSingle;

public interface BookSingleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookSingle record);

    int insertSelective(BookSingle record);

    BookSingle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookSingle record);

    int updateByPrimaryKey(BookSingle record);
}