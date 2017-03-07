package com.wtlib.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtlib.constants.DataStatusEnum;
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
	public Integer insert(CreditInfo entity) throws Exception {
		Integer num = creditInfoMapper.insert(entity);
		return num;
	}

	@Override
	public int insertBatch(List<CreditInfo> entityList) throws Exception {
		return 0;
	}

	@Override
	public CreditInfo selectById(Object id,String dataStatus) throws Exception {
		CreditInfo info = creditInfoMapper.selectById(id,dataStatus);
		return info;
	}

	@Override
	public List<CreditInfo> selectAll(String dataStatus) throws Exception {
		List<CreditInfo> creditList = creditInfoMapper.selectAll(dataStatus);
		return creditList;
	}

	@Override
	public int deleteById(Object id,Object reviser) throws Exception {
		int num = creditInfoMapper.deleteById(id, reviser);
		return num;
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
