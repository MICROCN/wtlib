package com.test.component;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.ConvertUtilsBean;
import org.apache.commons.beanutils.converters.DateConverter;
import org.dbunit.dataset.Column;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.excel.XlsDataSet;

import com.wtlib.util.ExeclUtil;

/**
 * 从EXCEL数据集文件创建Bean
 */
public class XlsDataSetBeanFactory {

	// 从DbUnit的EXCEL数据集文件创建多个bean
	public static <T> List<T> createBeans(String file, String tableName,
			Class<T> clazz) throws Exception {
		BeanUtilsBean beanUtils = createBeanUtils();
		List<Map<String, Object>> propsList = createProps(file, tableName);
		List<T> beans = new ArrayList<T>();
		for (Map<String, Object> props : propsList) {
			T bean = clazz.newInstance();
			beanUtils.populate(bean, props);
			beans.add(bean);
		}
		return beans;
	}

	// 从DbUnit的EXCEL数据集文件创建多个bean
	public static <T> T createBean(String file, String tableName, Class<T> clazz)
			throws Exception {
		BeanUtilsBean beanUtils = createBeanUtils();
		List<Map<String, Object>> propsList = createProps(file, tableName);
		T bean = clazz.newInstance();
		System.out.println(propsList.size());
		beanUtils.populate(bean, propsList.get(0));
		return bean;
	}

	private static List<Map<String, Object>> createProps(String file,
			String tableName) throws IOException, DataSetException {
		return new ExeclUtil().read(XlsDataSetBeanFactory.class.getResourceAsStream(file),
				tableName, true);
	}

	
	private static BeanUtilsBean createBeanUtils() {
		ConvertUtilsBean convertUtilsBean = createConverUtils();
		return new BeanUtilsBean(convertUtilsBean);
	}

	private static ConvertUtilsBean createConverUtils() {
		DateConverter dateConverter = new DateConverter();
		dateConverter.setPattern("yyyy-MM-dd");
		ConvertUtilsBean convertUtilsBean = new ConvertUtilsBean();
		convertUtilsBean.register(dateConverter, java.util.Date.class);
		convertUtilsBean.register(dateConverter, Timestamp.class);
		convertUtilsBean.register(dateConverter, java.sql.Date.class);
		return convertUtilsBean;
	}
}