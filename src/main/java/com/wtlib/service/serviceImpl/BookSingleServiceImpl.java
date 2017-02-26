package com.wtlib.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.omg.PortableInterceptor.SUCCESSFUL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.wtlib.constants.CreditEnum;
import com.wtlib.dao.BookBaseSupportMapper;
import com.wtlib.dao.BookSingleMapper;
import com.wtlib.dao.BorrowRecordMapper;
import com.wtlib.dao.CreditInfoMapper;
import com.wtlib.dao.CreditRecordMapper;
import com.wtlib.dao.UserInfoMapper;
import com.wtlib.dao.UserLevelMapper;
import com.wtlib.dao.UserMapper;
import com.wtlib.pojo.BookBaseSupport;
import com.wtlib.pojo.BookSingle;
import com.wtlib.pojo.BorrowRecord;
import com.wtlib.pojo.CreditInfo;
import com.wtlib.pojo.CreditRecord;
import com.wtlib.pojo.UserInfo;
import com.wtlib.pojo.UserLevel;
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
	@Autowired
	CreditInfoMapper creditInfoMapper;
	@Autowired
	UserInfoMapper userInfoMapper;
	@Autowired
	UserLevelMapper userLevelMapper;
	
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
		Integer reviser = entity.getReviser();
		BookBaseSupport support = bookBaseSupportMapper.selectById(id);
		support.setReviser(reviser);
		Integer book= support.getCurrentLeftBookNumber()-1;
		Assert.isTrue(book>=0,"无法借阅书！");
		Integer reservation = support.getCurrentReservateNumber();
		//如果有预定的人，则就提示所有预定的人书已被借。
		if(reservation!=0){
			//TODO 通知所有预定的人书已经被借走，是否预定。
		}
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
		//添加一条借阅记录
		Calendar cal = Calendar.getInstance(); 
		cal.add(Calendar.DATE, 30);
		Date date = cal.getTime();
		BorrowRecord record = new BorrowRecord(id,reviser,date);
		borrowRecordMapper.insert(record);
		return num;
	}
	
	@Override
	public void editReturnBack(BookSingle entity) throws Exception {
		//用book_hash作为查询属性查询到book_single对象
		//先要保存现在的修改者的id
		Integer nowReviser = entity.getReviser();
		entity = bookSingleMapper.findByHash(entity);
		Integer baseId = entity.getBookBaseId();
		Date oldUpdateTime = entity.getUpdateTime();
		Integer oldReviser = entity.getReviser();
		Integer singleId = entity.getId();
		//将原来的修改者和修改时间赋值为上一次借阅时间和上一个借阅人
		entity.setLastLender(oldReviser);
		entity.setLastLendTime(oldUpdateTime);
		entity.setReviser(nowReviser);
		//通过book_base_id查询book_base_support对象
		BookBaseSupport support = bookBaseSupportMapper.findByBaseId(baseId);
		//将图书设为可借阅，并把剩余可借人数+1，判断是否有预约的人。
		support.setIsBorrowAble("1");
		Integer borrowNum = support.getCurrentLeftBookNumber();
		support.setCurrentLeftBookNumber(borrowNum++);
		Integer reservation = support.getCurrentReservateNumber();
		if(reservation!=0){
			//TODO 发邮件通知所有的人可预约。
		}
		//借阅记录
		BorrowRecord record = borrowRecordMapper.selectBySingleId(singleId);
		String borrowStatus = record.getBorrowStatus();
		//用userid查userlevelid与userlevel表匹配
		UserInfo userInfo = userInfoMapper.selectByUserId(nowReviser);
		Integer levelId = userInfo.getCurrentCreditLevel();
		UserLevel level = userLevelMapper.selectById(levelId);
		Double levelWeight= level.getLevelWeight();
		double levelValue;
		CreditRecord creditRecord = new CreditRecord();
		if(borrowStatus.equals("002")){
			//就是说他超时未还。
			CreditInfo CreditInfo = creditInfoMapper.selectById(CreditEnum.overtime.getId());
			String plus =  CreditInfo.getIsPlus();
			creditRecord.setCreditIsPlus(plus);
			creditRecord.setCreditInfoId(CreditEnum.overtime.getId());
			creditRecord.setCreditName(CreditEnum.overtime.getName());
			Integer value = CreditInfo.getCreditValue();
			creditRecord.setCreditValue(value);
			if(plus.equals("1")){
				levelValue = value*levelWeight;
			} else{
				levelValue = -value*levelWeight;
			}
		} else{
			//就是说他还书成功
			CreditInfo CreditInfo = creditInfoMapper.selectById(CreditEnum.successReturn.getId());
			String plus =  CreditInfo.getIsPlus();
			creditRecord.setCreditIsPlus(plus);
			creditRecord.setCreditIsPlus(plus);
			creditRecord.setCreditInfoId(CreditEnum.overtime.getId());
			creditRecord.setCreditName(CreditEnum.overtime.getName());
			Integer value = CreditInfo.getCreditValue();
			creditRecord.setCreditValue(value);
			if(plus.equals("1")){
				levelValue = value*levelWeight;
			} else{
				levelValue = -value*levelWeight;
			}
		}
		//修改信用值。
		Integer oldValue = userInfo.getCurrentCreditValue();
		Integer currentValue = (int) (oldValue+levelValue);
		userInfo.setCurrentCreditValue(currentValue);
		userInfo.setReviser(nowReviser);
		//这里要update user一下,修改信用等级或者信用积分
		userInfo = userInfoMapper.updateLevel(userInfo);
		userInfoMapper.update(userInfo);
		//这里修改borrowRecord记录，将未归还变成归还，然后归还日期设为现在。
		record.setReviser(nowReviser);
		record.setReturnTime(new Date());
		record.setBorrowStatus("003");
		borrowRecordMapper.update(record);
		//记录一下信用记录
		creditRecord.setCreator(nowReviser);
		creditRecord.setCreditBeforeValue(oldValue);
		creditRecord.setCreditAfterValue(currentValue);
		creditRecordMapper.insert(creditRecord);
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
