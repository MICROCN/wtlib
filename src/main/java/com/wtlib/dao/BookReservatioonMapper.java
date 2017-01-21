package com.wtlib.dao;

import com.wtlib.pojo.BookReservatioon;

public interface BookReservatioonMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BookReservatioon record);

    int insertSelective(BookReservatioon record);

    BookReservatioon selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BookReservatioon record);

    int updateByPrimaryKey(BookReservatioon record);
}