package com.wtlib.service;


import com.wtlib.pojo.BookBaseLabelInfo;

public interface BookBaseLabelInfoService extends BaseService<BookBaseLabelInfo> {

	void deleteByLabelId(Object labelId,Object reviser);

}
