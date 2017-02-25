package com.wtlib.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wtlib.service.CreditInfoService;

/**
 * @Description: 信用相关控制类
 * @author zongzi
 * @date 2017年1月22日 下午2:39:21
 */
@Controller
@RequestMapping("/creditinfo/")
public class CreditInfoController {
	@Autowired
	private CreditInfoService creditInfoService;
}
