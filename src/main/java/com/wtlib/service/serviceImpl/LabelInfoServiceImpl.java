package com.wtlib.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wtlib.dao.LabelInfoMapper;
import com.wtlib.pojo.BookBaseLabelInfo;
import com.wtlib.pojo.LabelInfo;
import com.wtlib.service.BookBaseLabelInfoService;
import com.wtlib.service.LabelInfoService;

@Service("labelInfoService")
public class LabelInfoServiceImpl implements LabelInfoService {

	@Autowired
	LabelInfoMapper labelInfoMapper;
	
	@Resource(name="BookBaseLabelInfoService")
	BookBaseLabelInfoService bookBaseLabelInfoService;
	
	 
	@Override
	public int insert(LabelInfo info) throws Exception {
		//将信息写入LabelInfo表
		Integer id= labelInfoMapper.insert(info);
		Integer userId = info.getUserId();
		//将信息写入关联表LabelInfoUserId
		BookBaseLabelInfo bookLabel = new BookBaseLabelInfo(id,userId);
		int num = bookBaseLabelInfoService.insert(bookLabel);
		return num;
	}

	@Override
	public int deleteById(Object id) throws Exception {
		int labelId = labelInfoMapper.deleteById(id);
		bookBaseLabelInfoService.deleteByLabelId(labelId);
		return labelId;
	}
	
	@Override
	public int insertBatch(List<LabelInfo> entityList) throws Exception {
		return 0;
	}

	@Override
	public LabelInfo selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabelInfo> selectAll() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(LabelInfo entity) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public LabelInfo find(Object str) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LabelInfo> selectByBaseId(Integer id) {
		return labelInfoMapper.selectByBaseId(id);
	}

}
