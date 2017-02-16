package com.test.service;

import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.unitils.spring.annotation.SpringApplicationContext;

import com.test.component.XlsDataSetBeanFactory;
import com.test.dao.BaseDaoTest;
import com.wtlib.dao.BookBaseMapper;
import com.wtlib.dao.BookBaseSupportMapper;
import com.wtlib.dao.BookReservationMapper;
import com.wtlib.pojo.BookReservation;
import com.wtlib.pojo.User;
import com.wtlib.service.BookReservationService;
import com.wtlib.service.serviceImpl.BookReservationServiceImpl;

/**
 * ClassName: BookBaseServiceTest
 * 
 * @Description: 测试基本图书测试
 * @author zongzi
 * @date 2017年2月13日 下午2:06:09
 */
@SpringApplicationContext({ "test-spring.xml", "test-spring-mybatis.xml",
		"test-spring-aop.xml" })
public class BookReservationServiceTest extends BaseDaoTest {

	
	private BookBaseMapper bookBaseMapper;

	private BookReservationMapper bookReservationMapper;

	private BookBaseSupportMapper bookBaseSupportMapper;

	@Before
	public void init() {
		bookBaseMapper = mock(BookBaseMapper.class);// 创建mapper的模拟对象
		bookReservationMapper = mock(BookReservationMapper.class);
		bookBaseSupportMapper = mock(BookBaseSupportMapper.class);
	}

	@Test
	public void reservationABookByUser() {
		try {
			List<BookReservation> br = XlsDataSetBeanFactory.createBeans(
					excelFilePath + "/wtlib.testdatasource.xls",
					"t_book_reservation", BookReservation.class);
			BookReservation bookReservation = br.get(0);
			doReturn(new Integer(1)).when(bookReservationMapper).insert(
					bookReservation);

			
			BookReservationService bookReservationService = new BookReservationServiceImpl();

			// 预约一本新的书籍
			bookReservationService.insertNewBookReservation(111, 111);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
