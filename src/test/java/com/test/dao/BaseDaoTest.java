package com.test.dao;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.junit.Test;
import org.unitils.UnitilsJUnit4;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringApplicationContext;
import org.unitils.spring.annotation.SpringBeanByType;

import com.test.component.XlsDataSetBeanFactory;
import com.wtlib.dao.UserMapper;
import com.wtlib.pojo.User;

//数据访问层测试类
@SpringApplicationContext({ "classpath:spring-mybatis.xml",
		"classpath:spring.xml", "classpath:spring-aop.xml" })
public class BaseDaoTest {

	@SpringBeanByType
	UserMapper userMapper;

	@Test
	public void saveUser() throws Exception {
		User u = XlsDataSetBeanFactory.createBean("wtlib.SaveUser.xls",
				"t_user", User.class);
		u.toString();
		userMapper.save(u);
		
	}
}
