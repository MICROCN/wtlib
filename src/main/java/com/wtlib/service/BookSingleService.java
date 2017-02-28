package com.wtlib.service;

import com.wtlib.pojo.BookSingle;

/**
 * @Description: 基础图书接口
 * @author zongzi
 * @date 2017年1月22日 下午1:45:44
 */
public interface BookSingleService extends BaseService<BookSingle> {

	/**
	 * 归还图书接口
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	void editReturnBack(BookSingle entity) throws Exception;

}
