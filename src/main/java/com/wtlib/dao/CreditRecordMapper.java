package com.wtlib.dao;

import org.apache.ibatis.annotations.Param;

import com.wtlib.pojo.CreditRecord;

/**
 * @author zongzi
 * @date 2017年1月21日 下午6:13:48
 */
public interface CreditRecordMapper extends BaseDao<CreditRecord> {

	CreditRecord selectByUserId(@Param("userId") Integer userId,@Param("dataStatus") String dataStatus);
}