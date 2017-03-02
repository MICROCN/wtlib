package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtlib.dao.CreditInfoMapper;
import com.wtlib.pojo.CreditInfo;
import com.wtlib.service.CreditInfoService;

/**
 * @author zongzi
 * @date 2017年1月22日 下午2:04:38
 */
@Service("creditInfoService")
public class CreditInfoServiceImpl implements CreditInfoService {

	@Autowired
	CreditInfoMapper creditInfoMapper;
	@Override
	public int insert(CreditInfo entity) throws Exception {
		return 0;
	}

	@Override
	public int insertBatch(List<CreditInfo> entityList) throws Exception {
		return 0;
	}

	@Override
	public CreditInfo selectById(Object id) throws Exception {
		creditInfoMapper.selectById(id);
		return null;
	}

	@Override
	public List<CreditInfo> selectAll() throws Exception {
		return null;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		return 0;
	}

	@Override
	public int update(CreditInfo entity) throws Exception {
		return 0;
	}

	@Override
	public CreditInfo find(Object str) {
		return null;
	}

}
