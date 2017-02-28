package com.test.service;

import org.springframework.context.ApplicationContext;
import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

@SpringApplicationContext({ "test-spring.xml", "test-spring-mybatis.xml",
		"test-spring-aop.xml" })
public class BaseServiceTest extends UnitilsJUnit4 {
	
	@SpringApplicationContext
	public ApplicationContext applicationContext;
}
