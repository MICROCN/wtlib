package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtlib.dao.UserMapper;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	public void save(User user) {
		userMapper.save(user);
	}

	public int update(User user) {
		try {
			return userMapper.update(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public User find(String user) {
		return new User();
	}

	public void delete(String id) throws Exception {
		userMapper.deleteById(id);
	}

	@Override
	public int insert(User entity) throws Exception {
		return userMapper.insert(entity);
	}

	@Override
	public int insertBatch(List<User> entityList) throws Exception {
		return 0;
	}

	@Override
	public User selectById(Object id) throws Exception {
		return null;
	}

	@Override
	public List<User> selectAll() throws Exception {
		return null;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		return 0;
	}

	@Override
	public User getUserByLoginId(String loginId) throws Exception {
		return userMapper.selectById(loginId);
	}

}
