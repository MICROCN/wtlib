package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.dao.UserInfoMapper;
import com.wtlib.dao.UserMapper;
import com.wtlib.dto.UserWebDto;
import com.wtlib.pojo.User;
import com.wtlib.pojo.UserInfo;
import com.wtlib.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	@Autowired
	UserInfoMapper userInfoMapper;
	public int update(User user)  throws Exception{
		int num = userMapper.update(user);
		return num;
	}

	public UserWebDto find(String loginId) {
		UserWebDto user= userMapper.selectByLoginId(loginId);
		return user;
	}

	
	@Override
	public int deleteById(Object id) throws Exception {
		//delete不仅要把userInfo表的status设为000还要把user表的status设为000
		int num= userMapper.deleteById(id);
		return num;
	}
	
	@Override
	public int insert(User user) throws Exception {
		String loginId = user.getLoginId();
		Integer creator= user.getCreator();
		UserInfo userInfo = new UserInfo(creator,loginId);
		int count= userInfoMapper.insert(userInfo);
		int num= userMapper.insert(user);
		return num;
	}

	@Override
	public int insertBatch(List<User> entityList) throws Exception {
		return 0;
	}

	@Override
	public User selectById(Object id) throws Exception {
		User user= userMapper.selectById(id);
		return user;
	}

	@Override
	public Integer confirm(User user) {
		Integer id= userMapper.confirm(user);
		return id;
	}
	
	@Override
	public List<User> selectAll() throws Exception {
		List<User> userList= userMapper.selectAll();

		  return userList;
	}

	@Override
	public User find(Object str) {
		return null;
	}

	@Override
	public void save(User user) throws Exception {
	}

	@Override
	public void selectAllById(Integer userid) {
		userMapper.selectByLoginId(loginId);
		return user;
	}

}
