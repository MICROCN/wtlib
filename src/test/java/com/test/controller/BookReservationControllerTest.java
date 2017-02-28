package com.test.controller;

import static org.junit.Assert.*;


import javax.ws.rs.core.MultivaluedMap;

import org.junit.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

//import com.wtlib.controller.BookReservationController;

@SpringApplicationContext({ "test-spring.xml", "test-spring-mybatis.xml",
		"test-spring-aop.xml","test-spring-mvc.xml" })
public class BookReservationControllerTest extends UnitilsJUnit4 {

	@SpringBeanByType
	private RestTemplate restTemplate;

	@SpringBeanByType
//	private BookReservationController bookReservationController;

	@Test
	public void addTest() throws Exception {

		LinkedMultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("userNmae", "tom");
		map.add("password", "1234");

		String postForObject = restTemplate.postForObject(
				"http://localhost/wtlib/bookreservation/test.html", map,
				String.class);

		assertNotNull(postForObject);
	}
}
