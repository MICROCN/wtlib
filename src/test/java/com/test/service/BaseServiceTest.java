package com.test.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext({ "spring.xml", "spring-mybatis.xml","spring-aop.xml" })
public class BaseServiceTest extends UnitilsJUnit4 {

	@SpringApplicationContext
	public ApplicationContext applicationContext;

	@Test
	public void testServiceStart() {
		System.out.println("ServiceTest Strated");
	}
}
