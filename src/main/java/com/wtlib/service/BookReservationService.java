<<<<<<< HEAD
package com.wtlib.service;

import com.wtlib.pojo.BookReservation;

/**
 * ClassName: BookReservationService
 * 
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午1:44:41
 */
public interface BookReservationService extends BaseService<BookReservation> {

	/**
	 * user 预约书籍
	 * 
	 * @param @param bookId
	 * @param @param userId
	 * @param @return
	 * @author zongzi
	 * @date 2017年2月13日 下午5:49:15
	 */
	public Boolean insertNewBookReservation(Integer bookId, Integer userId)
			throws Exception;
}
=======
package com.wtlib.service;

import com.wtlib.pojo.BookReservation;

/**
 * ClassName: BookReservationService
 * 
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午1:44:41
 */
public interface BookReservationService extends BaseService<BookReservation> {

	/**
	 * user 预约书籍服务
	 * 
	 * @param @param bookId
	 * @param @param userId
	 * @param @return
	 * @author zongzi
	 * @date 2017年2月13日 下午5:49:15
	 */
	public Boolean insertNewBookReservation(Integer bookId, Integer userId)
			throws Exception;
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
