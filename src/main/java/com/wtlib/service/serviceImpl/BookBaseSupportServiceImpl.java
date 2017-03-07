package com.wtlib.service.serviceImpl;

import java.util.ArrayList;
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
		BookBase base = bookBaseService.selectById(id,DataStatusEnum.NORMAL_USED.getCode());
		dto.setBook(base);
		List<LabelInfo> labelInfo= labelInfoService.selectByBaseId(id,DataStatusEnum.NORMAL_USED.getCode());
		dto.setLabelList(labelInfo);
		List<UserWebDto> UserWebDtoList = new ArrayList<UserWebDto>();
		for(LabelInfo info :labelInfo){
			Integer userid = info.getUserId();
		    UserWebDto userDto =userService.selectAllById(userid,DataStatusEnum.NORMAL_USED.getCode());
		    UserWebDtoList.add(userDto);
		}
		dto.setUserDto(UserWebDtoList);
		return dto;
	}
	
	@Override
	public int deleteById(Object id,Object reviser) throws Exception {
		Integer num = baseSupportMapper.deleteById(id,reviser);
		return num;
	}

	@Override
	public int update(BookBaseSupport entity) throws Exception {
		Integer num = baseSupportMapper.update(entity);
		return num;
	}
	
	
	@Override
	public Integer insert(BookBaseSupport entity) throws Exception {
		Integer num = baseSupportMapper.insert(entity);
		return num;
	}

	@Override
	public int insertBatch(List<BookBaseSupport> entityList) throws Exception {
		return 0;
	}


	@Override
	public List<BookBaseSupport> selectAll(String dataStatus) throws Exception {
		return null;
	}


	@Override
	public BookBaseSupport find(Object str) {
		return null;
	}

	@Override
	public BookBaseSupport selectById(Object id,String dataStatus) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookBaseSupport selectBookBaseSupportByBookBaseId(Integer id,
			String code) {
		BookBaseSupport support= baseSupportMapper.selectBookBaseSupportByBookBaseId(id,code);
		return support;
	}

	@Override
	public Integer updateByBookId(BookBaseSupport bookBaseSupportTemp) {
		Integer num= baseSupportMapper.updateByBookId(bookBaseSupportTemp);
		return num;
	}
	
}
