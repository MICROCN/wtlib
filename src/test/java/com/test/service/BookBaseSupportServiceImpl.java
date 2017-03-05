package com.test.service;

import java.util.List;

import org.junit.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;

import com.test.BaseTestStarter;
import com.test.component.XlsDataSetBeanFactory;
import com.wtlib.dto.SupportWebDto;
import com.wtlib.pojo.BookBaseLabelInfo;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.service.BookBaseLabelInfoService;
import com.wtlib.service.BookBaseSupportService;

public class BookBaseSupportServiceImpl extends BaseTestStarter {
	@SpringBean(value = "bookBaseSupportService")
	private BookBaseSupportService bookBaseSupportService;
	
	@Test
	public void selectSupport(){
		try {
			SupportWebDto support = bookBaseSupportService.selectByBaseId(13);
			System.out.println(support);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
