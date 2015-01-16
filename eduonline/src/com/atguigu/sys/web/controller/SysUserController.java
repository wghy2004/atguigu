package com.atguigu.sys.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.atguigu.frame.core.annotation.MethodLog;
import com.atguigu.frame.core.dao.BaseService;
import com.atguigu.frame.core.web.controller.BaseControllerImpl;
import com.atguigu.frame.core.web.domain.EasyUIPage;
import com.atguigu.sys.domain.SysUser;
import com.atguigu.sys.domain.SysUserProfile;
import com.atguigu.sys.service.SysUserService;

/**
 * UserController
 * 
 * @Description
 * @author wg
 * @date 2014年10月5日 下午3:01:45
 *
 */
@Controller
@RequestMapping("/sys/user")
public class SysUserController extends BaseControllerImpl<SysUser, SysUser> {

	@Autowired
	private SysUserService userService;

	@Override
	protected BaseService<SysUser> getBaseService() {
		return userService;
	}

	@Override
	@MethodLog(remark = "查询所有用户")
	public ModelAndView selectList(SysUser query, Pageable pageable) {
		return super.selectList(query, pageable);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	@ResponseBody
	public String selectListJson(SysUser query, Pageable pageable) {

		Page<SysUser> page = userService.queryPageList(query, pageable);

		return EasyUIPage.formPage(page).toString();
	}

}
