package com.atguigu.sys.web.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.sys.service.SysUserService;

/**
 * 后台首页地址
 * 
 * @author wg
 *
 */
@Controller
@RequestMapping("/sys/admin")
public class SysAdminController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {

		int todayRegCount = sysUserService.getRegisterCount(new Date());
		
		Calendar   cal   =   Calendar.getInstance();
		cal.add(Calendar.DATE,   -1);
		  
		int yesterdayRegCount = sysUserService.getRegisterCount(cal.getTime());
		

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("todayRegCount", todayRegCount);
		map.put("yesterdayRegCount", yesterdayRegCount);

		return new ModelAndView("sys/index", "model", map);
	}
}
