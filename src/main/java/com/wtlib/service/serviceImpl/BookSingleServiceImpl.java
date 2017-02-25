package com.wtlib.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.dao.BookBaseSupportMapper;
import com.wtlib.dao.BookSingleMapper;
import com.wtlib.dao.BorrowRecordMapper;
import com.wtlib.dao.CreditRecordMapper;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.pojo.BookSingle;
import com.wtlib.pojo.BorrowRecord;
import com.wtlib.pojo.CreditRecord;
import com.wtlib.service.BookSingleService;

/**
 * @author zongzi
 * @date 2017年1月22日 下午2:01:00
 */
@Service("bookSingleService")
public class BookSingleServiceImpl implements BookSingleService {

	SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
	
	@Autowired
	BookSingleMapper bookSingleMapper;
	@Autowired
	BookBaseSupportMapper bookBaseSupportMapper;
	@Autowired
	BorrowRecordMapper borrowRecordMapper;
	@Autowired
	CreditRecordMapper creditRecordMapper;
	
	@Override
	public int insert(BookSingle entity) throws Exception {
		Integer num= bookSingleMapper.insert(entity);
		return num;
	}
	
	@Override
	public int deleteById(Object id) throws Exception {
		Integer num= bookSingleMapper.deleteById(id);
		return num;
	}
	
	@Override
	public int update(BookSingle entity) throws Exception {
		Integer id = entity.getBookBaseId();
		BookBaseSupport support = bookBaseSupportMapper.selectById(id);
		Integer book= support.getCurrentLeftBookNumber()-1;
		Assert.isTrue(book>=0,"无法借阅书！");
		if(book==0){
			support.setCurrentLeftBookNumber(0);
			support.setIsBorrowAble("0");
			support.setIsReservateAble("1");
		}
		else{
			support.setCurrentLeftBookNumber(book);
		}
		Integer num = bookSingleMapper.update(entity);
		bookBaseSupportMapper.update(support);
		return num;
	}
	
	@Override
	public boolean editReturnBack(BookSingle entity) throws Exception {
		//查询该归还的书籍信息
		Integer id = bookBaseSupportMapper.back(entity);
		Integer baseId = bookBaseSupportMapper.findBaseId(id);
		BookBaseSupport support = bookBaseSupportMapper.selectById(baseId);
		//将support表中记录的书的数量加一
		Integer num = support.getCurrentReservateNumber();
		Integer bookNum = support.getCurrentLeftBookNumber();
		Integer userId = entity.getReviser();
		bookNum++;
		//判断是否有人预约，如果有，则提醒预约的人可以借书，如果没有则设为可借
		if(num==0){
			support.setIsBorrowAble("1");
			support.setIsReservateAble("0");
		} else{
			Assert.isTrue(bookNum*2>num,"预约人数超过书本两倍");
			//TODO 邮件提示所有预定者。
			//TODO mail.send("可以借书了！");
		}
		support.setReviser(userId);
		support.setCurrentLeftBookNumber(bookNum);
		bookBaseSupportMapper.update(support);
		//在record里面记录下借书的情况
		BorrowRecord record = new BorrowRecord(id, userId);
		Integer borrowId = borrowRecordMapper.findRecord(record);
		record = borrowRecordMapper.selectById(borrowId);
		String status = record.getDataStatus();
		//TODO 判断书籍归还是否超时，如果超时则扣除积分，如果不超时则增加积分。
		CreditRecord credit = creditRecordMapper.selectByUserId(userId);
		Integer value = credit.getCreditAfterValue();
		if(status.equals("002")){
			Integer day = 0; 
			Date deadLine = record.getBorrowDeadLine();
			Date now = new Date();
			day = (int) ((now.getTime() - deadLine.getTime()) / (24 * 60 * 60 * 1000)); 
			credit.setCreator(userId);
			value = value - day*0;
			credit.setCreditBeforeValue(1);
			//TODO zongzi 这里是插入操作不是更新操作 
			creditRecordMapper.update(credit);
		}
		return false;
	}

	@Override
	public int insertBatch(List<BookSingle> entityList) throws Exception {
		return 0;
	}

	@Override
	public BookSingle selectById(Object id) throws Exception {
		return null;
	}

	@Override
	public List<BookSingle> selectAll() throws Exception {
		return null;
	}

	@Override
	public BookSingle find(Object str) {
		return null;
	}

}
