<<<<<<< HEAD
package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.BookSingleService;

/**
 * @author zongzi
 * @date 2017年1月22日 下午2:29:58
 */
@Controller
@RequestMapping("/booksingle/")
public class BookSingleController {
	@Autowired
	private BookSingleService booService;
}
=======
package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.BookSingleService;

/**
 * @author zongzi
 * @date 2017年1月22日 下午2:29:58
 */
@Controller
@RequestMapping("/booksingle/")
public class BookSingleController {
	@Autowired
	private BookSingleService booService;
}
>>>>>>> 13e933be52e5968370d07c39840eeb83a1dabd09
