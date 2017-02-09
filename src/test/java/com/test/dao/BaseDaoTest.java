
 package com.test.dao;

import static org.junit.Assert.*;

import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBean;

import com.test.component.XlsDataSetBeanFactory;
import com.wtlib.dao.UserMapper;
import com.wtlib.pojo.User;

//数据访问层测试类

@SpringApplicationContext({ "classpath:test-spring-mybatis.xml",
		"classpath:test-spring.xml", "classpath:test-spring-aop.xml" })
public class BaseDaoTest extends UnitilsJUnit4 {

	public final static String excelFilePath = "../exceldataset";
	@SpringBean("userMapper")
	UserMapper userMapper;

//	@Test
	@ExpectedDataSet("../../resources/dataSetXls/wtlib.userSave.expect.xls")
	public void saveUser() throws Exception {
		User u = XlsDataSetBeanFactory.createBean(excelFilePath
				+ "/wtlib.SaveUser.xls", "t_user", User.class);
		int insert = userMapper.insert(u);
		System.out.println(insert);
	}

	@Test
	@DataSet("BaseDaoTest-findUserById.xml")
	public void findUserById() throws Exception {
		User user = userMapper.selectById(24);
		assertNotNull(user);
		System.out.println(user);
	}
}
