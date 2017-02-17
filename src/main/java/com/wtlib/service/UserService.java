package com.wtlib.service;

import com.wtlib.pojo.User;
import com.wtlib.pojo.UserWebDto;

/**
 * ClassName: UserService
 * 
 * @author zongzi
 * @date 2017年1月22日 下午1:36:22
 */
public interface UserService extends BaseService<User> {

	public void save(User user) throws Exception;

	public int update(User user) throws Exception;

	public UserWebDto find(String user) throws Exception;

	public void delete(String id) throws Exception;

	public User getUserByLoginId(String loginId) throws Exception;

}
