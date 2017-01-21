package com.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.wtlib.mq.MQDemo;
import com.wtlib.start.InterfaceUrlInti;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:spring.xml",
		"classpath:spring-mybatis.xml", "classpath:spring-mvc.xml"})
public class MainTest{
	 
	
	@Test
	public void test1() throws Exception {	
		InterfaceUrlInti.init();
		System.out.println("i add oneline in my computer and ready to push it to origin");		
		System.out.println("i fix this conflict in my computer and it's okey to push it to origin");
		MQDemo.Demo();
	 }
	
}
