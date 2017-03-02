package com.wtlib.dao;

import org.apache.ibatis.annotations.Param;

import com.wtlib.dto.UserWebDto;
import com.wtlib.pojo.UserInfo;

/**
 * @author pohoulong
 * @date 2017年1月21日 下午6:15:14
 */
public interface UserInfoMapper extends BaseDao<UserInfo> {
	
	public UserWebDto selectByUsername(@Param("username")String username,@Param("dataStatus") String dataStatus);

	public UserInfo selectByUserId(@Param("reviser")Integer nowReviser,@Param("dataStatus") String dataStatus);

	public UserInfo updateLevel(UserInfo userInfo);
	
}