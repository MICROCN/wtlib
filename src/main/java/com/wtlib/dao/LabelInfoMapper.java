package com.wtlib.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wtlib.pojo.BookBase;
import com.wtlib.pojo.LabelInfo;

public interface LabelInfoMapper extends BaseDao<LabelInfo>{

	List<LabelInfo> selectByBaseId(@Param("id")Integer id,@Param("dataStatus") String dataStatus);

}
