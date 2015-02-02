package com.atguigu.sys.interceptor;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.atguigu.frame.core.utils.SystemConfig;
import com.atguigu.sys.domain.SysUser;

/**
 * 用户登录拦截器
 * @author wg
 *
 */
@Repository
public class SystemInterceptor extends HandlerInterceptorAdapter {

	private String[] allowUrls;

	public void setAllowUrls(String[] allowUrls) {
		this.allowUrls = allowUrls;
	}

	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object object, Exception exception)
			throws Exception {
	}

	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object object, ModelAndView model)
			throws Exception {
	}

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object object) throws Exception {

		String requestUrl = request.getRequestURI().replace(
				request.getContextPath(), "");

		if (null != allowUrls && allowUrls.length >= 1)
			for (String url : allowUrls) {
				if (requestUrl.contains(url)) {
					return true;
				}
			}

		SysUser user = (SysUser) request.getSession().getAttribute("admin");

		if (null == user) {
			String url = SystemConfig.basePath + request.getServletPath();

			try {
				response.sendRedirect(SystemConfig.basePath + "/sys/login?url="
						+ url);
				return false;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return true;
	}

}