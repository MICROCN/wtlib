<<<<<<< HEAD
package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.CreditRecordSrevice;

/**
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午2:42:44
 */
@Controller
@RequestMapping("/creditrecord/")
public class CreditRecordController {
	@Autowired
	private CreditRecordSrevice creditRecordSrevice;
}
=======
package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.CreditRecordSrevice;

/**
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午2:42:44
 */
@Controller
@RequestMapping("/creditrecord/")
public class CreditRecordController {
	@Autowired
	private CreditRecordSrevice creditRecordSrevice;
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
