package com.test.controller;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unitils.spring.annotation.SpringBean;
import org.unitils.spring.annotation.SpringBeanByType;

import com.test.BaseTestStarter;
import com.wtlib.controller.BookMainController;

//import com.wtlib.controller.BookReservationController;

public class BookReservationControllerTest extends BaseTestStarter {

	@SpringBean(value = "bookMainController")
	private BookMainController bookMainController;

	@Test
	public void firstTest() throws Exception {
		assertNotNull(bookMainController);
	}
}
