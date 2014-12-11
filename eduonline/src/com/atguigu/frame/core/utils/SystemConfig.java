package com.atguigu.frame.core.utils;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import com.atguigu.sys.domain.SysUser;

public class SystemConfig {

	public static String basePath = "";
	static {
		try {
			Properties properties = new Properties();
			properties.load(SystemProperties.class.getClassLoader()
					.getResourceAsStream("system.properties"));
			basePath = (String) properties.get("basePath");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
/**
 * 获得登录用户
 * @param request
 * @return
 */
	public static SysUser getLoginUser(HttpServletRequest request) {

		return (SysUser)request.getSession().getAttribute("user");
	}

}
