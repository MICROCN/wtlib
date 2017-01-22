package com.wtlib.dao;

import com.wtlib.pojo.User;

/**
 * @author zongzi
 * @date 2017年1月21日 下午6:14:59
 */
public interface UserMapper extends BaseDao<User> {


	void save(User user);
}