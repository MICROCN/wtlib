package com.wtlib.service;

import java.util.List;

import com.wtlib.pojo.BookBaseSupport;

public interface BookBaseSupportService extends BaseService<BookBaseSupport> {

	BookBaseSupport selectByBaseId(Integer id) throws Exception;

}
