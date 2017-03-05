package com.wtlib.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.constants.DataStatusEnum;
import com.wtlib.dao.UserInfoMapper;
import com.wtlib.dao.UserMapper;
import com.wtlib.dto.UserWebDto;
import com.wtlib.pojo.User;
import com.wtlib.pojo.UserInfo;
import com.wtlib.service.UserInfoService;
import com.wtlib.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;
	@Resource(name ="userInfoService")
	UserInfoService userInfoService;
	public int update(User user)  throws Exception{
		int num = userMapper.update(user);
		return num;
	}

	public UserWebDto find(String loginId,String dataStatus) {
		UserWebDto user= userMapper.selectByLoginId(loginId,dataStatus);
		return user;
	}

	
	@Override
	public int deleteById(Object id,Object reviser) throws Exception {
		//delete不仅要把userInfo表的status设为000还要把user表的status设为000
		int num= userMapper.deleteById(id,reviser);
		return num;
	}
	
	@Override
	public Integer insert(User user) throws Exception {
		String loginId = user.getLoginId();
		Integer creator= user.getCreator();
		UserInfo userInfo = new UserInfo(creator,loginId);
		int count= userInfoService.insert(userInfo);
		int num= userMapper.insert(user);
		return num;
	}

	@Override
	public int insertBatch(List<User> entityList) throws Exception {
		return 0;
	}

	@Override
	public User selectById(Object id,String dataStatus) throws Exception {
		User user= userMapper.selectById(id,DataStatusEnum.NORMAL_USED.getCode());
		return user;
	}

	@Override
	public Integer confirm(User user) {
		Integer id= userMapper.confirm(user,DataStatusEnum.NORMAL_USED.getCode());
		return id;
	}
	
	@Override
	public List<User> selectAll(String dataStatus) throws Exception {
		List<User> userList= userMapper.selectAll(DataStatusEnum.NORMAL_USED.getCode());

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
	public UserWebDto selectAllById(Integer userid,String dataStatus) {
		UserWebDto user= userMapper.selectAllById(userid,dataStatus);
		return user;
	}

}
