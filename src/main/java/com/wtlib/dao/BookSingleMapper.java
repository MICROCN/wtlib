package com.wtlib.dao;

import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.pojo.BookSingle;

/**
 * @author zongzi
 * @date 2017年1月21日 下午6:17:01
 */
public interface BookSingleMapper extends BaseDao<BookSingle> {
	public BookSingle findByHash(String hash);

	public BookSingle findById(Object id);

	public void deleteByBaseId(Integer id);
}