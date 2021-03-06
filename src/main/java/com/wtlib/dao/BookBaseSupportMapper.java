<<<<<<< HEAD
package com.wtlib.dao;

import org.apache.ibatis.annotations.Param;

import com.wtlib.pojo.BookBaseSupport;

/**
 * ClassName: BookBaseSupportMapper
 * 
 * @Description: 图书扩展类
 * @author zongzi
 * @date 2017年2月15日 上午11:58:56
 */
public interface BookBaseSupportMapper extends BaseDao<BookBaseSupport> {

	public BookBaseSupport selectBookBaseSupportByBookId(
			@Param("bookId") Integer bookId,
			@Param("dataStatus") String dataStatus);

	/**
	 * 根据bookbaseSupport的bookId来更新图书辅助表信息
	 * 
	 * @param @param bookBaseSupportTemp
	 * @param @return
	 * @author zongzi
	 * @date 2017年2月15日 下午1:56:11
	 */
	public Integer updateByBookId(BookBaseSupport bookBaseSupportTemp);

=======
package com.wtlib.dao;

import org.apache.ibatis.annotations.Param;

import com.wtlib.pojo.BookBaseSupport;

/**
 * ClassName: BookBaseSupportMapper
 * 
 * @Description: 图书扩展类
 * @author zongzi
 * @date 2017年2月15日 上午11:58:56
 */
public interface BookBaseSupportMapper extends BaseDao<BookBaseSupport> {

	public BookBaseSupport selectBookBaseSupportByBookId(
			@Param("bookId") Integer bookId,
			@Param("dataStatus") String dataStatus);

	/**
	 * 根据bookbaseSupport的bookId来更新图书辅助表信息
	 * 
	 * @param @param bookBaseSupportTemp
	 * @param @return
	 * @author zongzi
	 * @date 2017年2月15日 下午1:56:11
	 */
	public Integer updateByBookId(BookBaseSupport bookBaseSupportTemp);

>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
}