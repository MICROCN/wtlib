package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wtlib.pojo.UserInfo;
import com.wtlib.service.UserInfoService;

/**
 * @author zongzi
 * @date 2017年1月22日 下午2:07:56
 */
@Service("userInfoService")
public class UserInfoServiceImpl implements UserInfoService {

	@Override
	public int insert(UserInfo entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertBatch(List<UserInfo> entityList) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<UserInfo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(UserInfo entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfo find(Object str) {
		// TODO Auto-generated method stub
		return null;
	}

}
