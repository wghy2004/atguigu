package com.atguigu.sys.web.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.frame.core.utils.MD5Util;
import com.atguigu.sys.domain.SysUser;
import com.atguigu.sys.service.SysUserService;

/**
 * 后台登录
 * 
 * @author wg
 *
 */
@Controller
@RequestMapping("/sys/logout")
public class SysLogoutController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 退出
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView logout(HttpServletRequest request,
			HttpServletResponse response) {

		request.getSession().removeAttribute("admin");

		return new ModelAndView("redirect:/sys/login");
	}

}
