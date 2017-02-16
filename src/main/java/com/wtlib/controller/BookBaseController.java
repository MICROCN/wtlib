<<<<<<< HEAD
package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.BookBaseService;

/**
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午2:26:54
 */
@Controller
@RequestMapping("/bookbase/")
public class BookBaseController {
	@Autowired
	private BookBaseService baseService;
}
=======
package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.BookBaseService;

/**
 * @Description: TODO
 * @author zongzi
 * @date 2017年1月22日 下午2:26:54
 */
@Controller
@RequestMapping("/bookbase/")
public class BookBaseController {
	@Autowired
	private BookBaseService baseService;
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
