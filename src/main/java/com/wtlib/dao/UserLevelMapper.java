package com.wtlib.dao;

import com.wtlib.pojo.UserLevel;

/**
 * @author zongzi
 * @date 2017年1月21日 下午6:16:11
 */
public interface UserLevelMapper extends BaseDao<UserLevel> {

	Double selectByUserId(Integer nowReviser);
}