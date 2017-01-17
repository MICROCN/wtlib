package com.wtlib.dao;

import com.wtlib.pojo.User;

/**
 * ClassName: UserDao
 * @Description: dao层直接声明接口,在mapper实现
 * @author dapengniao
 * @date 2016年6月25日 上午11:52:36
 */
public interface UserDao {
	public void save(User user);
	public void update(User user);
	public  User find(String id);
	public void delete(String id);
}
