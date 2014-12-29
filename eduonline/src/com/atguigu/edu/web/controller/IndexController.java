package com.atguigu.edu.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.sys.service.SysUserService;

/**
 * 首页地址
 * @author wg
 *
 */
@Controller
@RequestMapping("/edu/index")
public class IndexController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView index() {
		return new ModelAndView("edu/index");
	}
}
