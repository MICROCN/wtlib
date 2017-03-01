package com.wtlib.service;

import java.util.List;

import com.wtlib.pojo.LabelInfo;

public interface LabelInfoService extends BaseService<LabelInfo> {

	List<LabelInfo> selectByBaseId(Integer id);

}
