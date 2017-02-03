package com.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.unitils.reflectionassert.ReflectionAssert;

import org.unitils.UnitilsJUnit4;
import org.unitils.spring.annotation.SpringApplicationContext;

import com.wtlib.pojo.User;
import com.wtlib.start.InterfaceUrlInti;

public class UserTest extends UnitilsJUnit4 {
	protected static ClassPathXmlApplicationContext context = null;

	static {
		InterfaceUrlInti.init();
		/*
		 * context = new ClassPathXmlApplicationContext(new String[] {
		 * "classpath:spring-mybatis.xml", "classpath:spring.xml",
		 * "classpath:spring-aop.xml" });
		 */
	}

	// @Test
	public void testReflection() {
		User user = new User();
		user.setLoginId("tom");
		User user2 = new User();
		user2.setLoginId("tom1");
		// ReflectionAssert.assertReflectionEquals(user, user2);
	}

	@SpringApplicationContext({ "classpath:spring-mybatis.xml",
			"classpath:spring.xml", "classpath:spring-aop.xml" })
	private static ApplicationContext applicationContext;

	// @SpringBean("userService")
	// private UserService userService;

	@Test
	public void testUserService() {

		System.out.println("done");

		assertNotNull(applicationContext);
		System.out.println("done");
	}
}
