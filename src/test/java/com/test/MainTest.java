<<<<<<< HEAD
package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtlib.mq.MQDemo;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;
import com.wtlib.start.InterfaceUrlInti;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring.xml",
//		"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class MainTest{
	 
	private static ClassPathXmlApplicationContext context = null;
	
	
	static{
		InterfaceUrlInti.init();
		context = new ClassPathXmlApplicationContext(new String[] {
				"classpath:spring-mybatis.xml", "classpath:spring.xml",
				"classpath:spring-aop.xml" });
	}
	
	private static UserService userService;
	@Test
	public void test1() throws Exception {	
		userService = (UserService)context.getBean("userService");
		User user = new User();
		user.setPassword("aaaaa");
		user.setLoginId("testtesttest");
		try{
			int insert = userService.insert(user);
			System.out.println(insert);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	 }
	
}
=======
package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtlib.mq.MQDemo;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;
import com.wtlib.start.InterfaceUrlInti;


//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring.xml",
//		"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class MainTest{
	 
	private static ClassPathXmlApplicationContext context = null;
	
	
	static{
		InterfaceUrlInti.init();
		context = new ClassPathXmlApplicationContext(new String[] {
				"classpath:spring-mybatis.xml", "classpath:spring.xml",
				"classpath:spring-aop.xml" });
	}
	
	private static UserService userService;
	@Test
	public void test1() throws Exception {	
		userService = (UserService)context.getBean("userService");
		User user = new User();
		user.setPassword("aaaaa");
		user.setLoginId("testtesttest");
		try{
			int insert = userService.insert(user);
			System.out.println(insert);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	 }
	
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
