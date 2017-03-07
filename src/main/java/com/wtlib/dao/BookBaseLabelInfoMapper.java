package com.wtlib.dao;

import org.apache.ibatis.annotations.Param;

import com.wtlib.pojo.BookBaseLabelInfo;

public interface BookBaseLabelInfoMapper extends BaseDao<BookBaseLabelInfo> {

	void deleteByLabelId(@Param("labelId")Object labelId,@Param("reviser") Object reviser);


}
