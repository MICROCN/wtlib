package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.dao.UserLevelMapper;
import com.wtlib.pojo.UserLevel;
import com.wtlib.service.UserLevelService;

/**
 * @author pohoulong
 * @date 2017年1月22日 下午2:08:48
 */
@Service("userLevelService")
public class UserLevelServiceImpl implements UserLevelService {

	@Autowired
	UserLevelMapper userLevelMapper;
	
	@Override
	public int insert(UserLevel entity) throws Exception {
		int num= userLevelMapper.insert(entity);
		return num;
	}

	@Override
	public int update(UserLevel entity) throws Exception {
		int num= userLevelMapper.update(entity);
		return num;
	}

	@Override
	public List<UserLevel> selectAll() throws Exception {
		List<UserLevel> levelList= userLevelMapper.selectAll();
		return levelList;
	}
	
	@Override
	public int deleteById(Object id) throws Exception {
		int num= userLevelMapper.deleteById(id);
		return num;
	}
	
	@Override
	public UserLevel selectById(Object id) throws Exception {
		UserLevel level = userLevelMapper.selectById(id);
		return level;
	}
	
	@Override
	public int insertBatch(List<UserLevel> entityList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserLevel find(Object str) {
		// TODO Auto-generated method stub
		return null;
	}

}
