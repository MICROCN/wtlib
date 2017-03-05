package com.wtlib.service;

import java.util.List;


import com.wtlib.dto.SupportWebDto;
import com.wtlib.pojo.BookBaseSupport;

public interface BookBaseSupportService extends BaseService<BookBaseSupport> {

	SupportWebDto selectByBaseId(Integer id) throws Exception;

	BookBaseSupport selectBookBaseSupportByBookBaseId(Integer id,String dataStatus);

	Integer updateByBookId(BookBaseSupport bookBaseSupportTemp);

}
