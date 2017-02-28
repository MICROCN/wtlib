package com.test;

//flicts test
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.wtlib.mq.MQDemo;
import com.wtlib.pojo.User;
import com.wtlib.service.UserService;
import com.wtlib.start.InterfaceUrlInti;
//ddsssssss

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = { "classpath:spring.xml",ddddddddddddddddddddddddd
//		"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class MainTest {

	private static ClassPathXmlApplicationContext context = null;

	static {
		InterfaceUrlInti.init();
		context = new ClassPathXmlApplicationContext(new String[] {
				"classpath:spring-mybatis.xml", "classpath:spring.xml",
				"classpath:spring-aop.xml" });
	}

	private static UserService userService;

	@Test
	public void test1() throws Exception {
		userService = (UserService) context.getBean("userService");
		User user = new User();
		user.setPassword("aaaaa");
		user.setLoginId("testtesttest");
		try {
			int insert = userService.insert(user);
			System.out.println(insert);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		User user = new User("jc", "sdfa");
		Class<? extends User> class1 = user.getClass();
		System.out.println(JSON.toJSONString(class1.getDeclaredMethods()));
		String[] methodNames = new String[] { "getLoginId" };
		for (String methodName : methodNames) {

			try {
				Method method = class1.getDeclaredMethod(methodName);
				Object invoke = method.invoke(user, null);
				System.out.println(JSON.toJSONString(invoke));
			} catch (Exception e) {

				e.printStackTrace();
			}
		}

		String[] filedNames = new String[] { "loginId", "password" };
		for (String filedName : filedNames) {
			Field field;
			try {
				field = class1.getDeclaredField(filedName);
				field.setAccessible(true);
				try {
					System.out.println(field.get(user));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
