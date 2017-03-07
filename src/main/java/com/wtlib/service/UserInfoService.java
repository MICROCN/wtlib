package com.wtlib.service;

import org.apache.ibatis.annotations.Param;

import com.wtlib.dto.UserWebDto;
import com.wtlib.pojo.UserInfo;

/**
 * @Description: 用户信息接口
 * @author zongzi
 * @date 2017年1月22日 下午1:49:47
 */
public interface UserInfoService extends BaseService<UserInfo> {
	
	public UserWebDto find(String username,String dataStataus);

	public UserInfo selectByUserId(Integer reviser,String dataStataus);
	
	
}
