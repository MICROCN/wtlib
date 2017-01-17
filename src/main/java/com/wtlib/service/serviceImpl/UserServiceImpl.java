package com.wtlib.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtlib.dao.UserDao;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;


@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired UserDao userdao;
	public void save(User user) {
		userdao.save(user);
	}

	public void update(User user) {
		userdao.update(user);
	}
	
	public User find(String user) {
		System.out.println("我是dubbox！"+user);
		return userdao.find(user);
	}

	public void delete(String id) {
		userdao.delete(id);		
	}
	
	
	

}
