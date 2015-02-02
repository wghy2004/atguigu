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
@RequestMapping("/sys/login")
public class SysLoginController {

	@Autowired
	private SysUserService sysUserService;

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView login(HttpServletRequest request,
			HttpServletResponse response) throws NoSuchAlgorithmException,
			IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String url = request.getParameter("url");

		SysUser user = new SysUser();

		user.setNickname(username);

		user = sysUserService.queryOne(user);

		if (!StringUtils.isEmpty(username) && !StringUtils.isEmpty(password)
				&& null != user
				&& MD5Util.MD5(password).equals(user.getPassword()) &&user.getRoles().equals("admin")) {

			// 登录成功
			request.getSession().setAttribute("admin", user);

			if (!StringUtils.isEmpty(url)) {
				return new ModelAndView("redirect:" + url);
			}

			return new ModelAndView("redirect:/sys/admin");
		}

		return new ModelAndView("sys/login", "message", "用户名或密码错误!");
	}


	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView loginView(HttpServletRequest request) {

		String url = request.getParameter("url");

		// 已经登录
		SysUser user = (SysUser) request.getSession().getAttribute("admin");

		if (null != user) {

			if (!StringUtils.isEmpty(url)) {
				return new ModelAndView("redirect:" + url);
			}

			return new ModelAndView("redirect:/sys/admin");
		}

		return new ModelAndView("sys/login", "url", url);
	}
}
