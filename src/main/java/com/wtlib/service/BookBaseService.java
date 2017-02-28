package com.wtlib.service;

import java.util.List;

import com.wtlib.pojo.BookBase;

/**
 * ClassName: BookBaseService
 * @Description: 基础图书服务类接口
 * @author zongzi
 * @date 2017年1月22日 下午1:44:46
 */
public interface BookBaseService extends BaseService<BookBase> {
	List<BookBase> find(String title);
}
