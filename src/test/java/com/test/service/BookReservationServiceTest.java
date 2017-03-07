package com.test.service;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import com.alibaba.fastjson.JSON;
import com.test.BaseTestStarter;
import com.test.component.XlsDataSetBeanFactory;
import com.wtlib.constants.DataStatusEnum;
import com.wtlib.dao.BookBaseMapper;
import com.wtlib.dao.BookBaseSupportMapper;
import com.wtlib.dao.BookReservationMapper;
import com.wtlib.pojo.BookBaseLabelInfo;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.pojo.BookReservation;
import com.wtlib.service.BookReservationService;
import com.wtlib.service.serviceImpl.BookReservationServiceImpl;

/**
 * ClassName: BookBaseServiceTest
 * 
 * @Description: 测试基本图书测试
 * @author zongzi
 * @date 2017年2月13日 下午2:06:09
 */

public class BookReservationServiceTest extends BaseTestStarter {

	@SpringBean(value = "bookReservationService")
	private BookReservationService bookReservationService;

//	@Test
	@DataSet("dataSetXls/BookReservationService/insertNewBookReservation.xls")
	@ExpectedDataSet("dataSetXls/BookReservationService/insertNewBookReservation.expect.xls")
	public void testInsertNewBookReservation() {
		try {
			List<BookReservation> brS = XlsDataSetBeanFactory.createBeans(
					"/wtlib.testdatasource.xls", "t_book_reservate_source",
					BookReservation.class);

			for (BookReservation br : brS) {
				int bookId = br.getBookId();
				int userId = br.getUserId();
				try {
					bookReservationService.insertNewBookReservation(bookId,
							userId);
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testStart() {
		 try {
			BookBaseLabelInfo newInstance = BookBaseLabelInfo.class.newInstance();
			System.out.println(newInstance);
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testStart1() {
	}
}
