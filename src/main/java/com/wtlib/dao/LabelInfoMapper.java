package com.wtlib.dao;

import java.util.List;

import com.wtlib.pojo.BookBase;
import com.wtlib.pojo.LabelInfo;

public interface LabelInfoMapper extends BaseDao<LabelInfo>{

	List<LabelInfo> selectByBaseId(Integer id);

}
