<<<<<<< HEAD
package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.BorrowRecordService;

/**
 * @author zongzi
 * @date 2017年1月22日 下午2:37:57
 */
@Controller
@RequestMapping("/borrowrecord/")
public class BorrowRecordController {
	@Autowired
	private BorrowRecordService borrowRecordService;
}
=======
package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.BorrowRecordService;

/**
 * @author zongzi
 * @date 2017年1月22日 下午2:37:57
 */
@Controller
@RequestMapping("/borrowrecord/")
public class BorrowRecordController {
	@Autowired
	private BorrowRecordService borrowRecordService;
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
