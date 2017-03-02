package com.wtlib.service.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.constants.DataStatusEnum;
import com.wtlib.dao.BookBaseMapper;
import com.wtlib.dao.BookBaseSupportMapper;
import com.wtlib.dao.LabelInfoMapper;
import com.wtlib.dto.SupportWebDto;
import com.wtlib.dto.UserWebDto;
import com.wtlib.pojo.BookBase;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.pojo.LabelInfo;
import com.wtlib.service.BookBaseService;
import com.wtlib.service.BookBaseSupportService;
import com.wtlib.service.LabelInfoService;
import com.wtlib.service.UserService;

@Service("bookBaseSupportService")
public class BookBaseSupportServiceImpl implements BookBaseSupportService{

	@Autowired
	BookBaseSupportMapper baseSupportMapper;
	
	
	@Resource(name = "labelInfoService")
	LabelInfoService labelInfoService;
	
	@Resource(name = "userService")
	UserService userService;
	
	
	@Resource(name = "bookBaseService")
	BookBaseService bookBaseService;
	
	@Override
	public SupportWebDto selectByBaseId(Integer id) throws Exception {
		BookBaseSupport support = baseSupportMapper.selectBookBaseSupportByBookBaseId(id,DataStatusEnum.NORMAL_USED.getCode());
		SupportWebDto dto = new SupportWebDto();
		dto.setSupport(support);
		BookBase base = bookBaseService.selectById(id);
		dto.setBook(base);
		List<LabelInfo> labelInfo= labelInfoService.selectByBaseId(id);
		dto.setLabelList(labelInfo);
		for(LabelInfo info :labelInfo){
			Integer userid = info.getUserId();
		    UserWebDto userDto =userService.selectAllById(userid);
		    dto.setUserDto(userDto);
		}
		return dto;
	}
	
	@Override
	public int deleteById(Object id) throws Exception {
		Integer num = baseSupportMapper.deleteById(id);
		return num;
	}

	@Override
	public int update(BookBaseSupport entity) throws Exception {
		Integer num = baseSupportMapper.update(entity);
		return num;
	}
	
	
	@Override
	public int insert(BookBaseSupport entity) throws Exception {
		Integer num = baseSupportMapper.insert(entity);
		return num;
	}

	@Override
	public int insertBatch(List<BookBaseSupport> entityList) throws Exception {
		return 0;
	}


	@Override
	public List<BookBaseSupport> selectAll() throws Exception {
		return null;
	}


	@Override
	public BookBaseSupport find(Object str) {
		return null;
	}

	@Override
	public BookBaseSupport selectById(Object id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookBaseSupport selectBookBaseSupportByBookBaseId(Integer id,
			String code) {
		BookBaseSupport support= baseSupportMapper.selectBookBaseSupportByBookBaseId(id,DataStatusEnum.NORMAL_USED.getCode());
		return support;
	}

	@Override
	public Integer updateByBookId(BookBaseSupport bookBaseSupportTemp) {
		Integer num= baseSupportMapper.updateByBookId(bookBaseSupportTemp);
		return num;
	}
	
}
