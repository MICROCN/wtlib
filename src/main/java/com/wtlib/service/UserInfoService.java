package com.wtlib.service;

import com.wtlib.pojo.UserInfo;
import com.wtlib.pojo.UserWebDto;

/**
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午1:49:47
 */
public interface UserInfoService extends BaseService<UserInfo> {
	
	public UserWebDto find(String username);
}
